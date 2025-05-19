package org.techdisqus.service.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.collections4.CollectionUtils;
import org.techdisqus.dao.ConfigDataDao;
import org.techdisqus.dao.request.QueryDaoRequest;
import org.techdisqus.dao.response.GraphQlError;
import org.techdisqus.dao.response.config.ConfigDataDaoResponse;
import org.techdisqus.service.KycBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * Maintains config data to transform the request for custom attributes.
 * Please be noted that this should be removed in future release upon TREX provides us a different API
 * As of now, it is stopgap solution.
 */
@Component
public class ConfigCacheManager extends KycBaseService {

    private final Logger logger = LoggerFactory.getLogger(ConfigCacheManager.class);

    @Autowired
    private ConfigDataDao configDataDao;

    private final Map<String, Long> fieldNameToCodeDefId = new ConcurrentHashMap<>();

    private final Map<Long, List<String>> codeDefIdToValues = new ConcurrentHashMap<>();

    private final Map<Long, Map<String, Long>> codeDefIdToValueIds = new ConcurrentHashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Value transformer instance and initialization flag
    private ValueTransformer valueTransformer;
    private final AtomicBoolean initialized = new AtomicBoolean(false);

    /**
     * initialise the cache and used for transformation while updating custom attributes
     */
    @PostConstruct
    public synchronized void initializeCodeListCache() {
        if (initialized.get()) {
            logger.info("Code list cache already initialized, skipping...");
            return;
        }

        try {
            logger.info("Initializing code list cache...");

            // Get all code list definitions
            JsonNode allCodeDefsWithValues = getCodeListDefinitions();
            if (allCodeDefsWithValues.has("data") && allCodeDefsWithValues.get("data").has("codeDefs")) {
                JsonNode codeDefs = allCodeDefsWithValues.get("data").get("codeDefs");
                logger.debug("Found {} code definitions with values", codeDefs.size());

                // Process each definition
                for (JsonNode def : codeDefs) {
                    String codeDefCode = def.get("code").asText();
                    long codeDefId = def.get("id").asLong();

                    // Transform the code to match the field name format (remove underscores)
                    String fieldName = transformFieldName(codeDefCode);

                    logger.debug("Processing code definition: {} -> {} (codeDefId: {})",
                            codeDefCode, fieldName, codeDefId);

                    // Store the mapping
                    fieldNameToCodeDefId.put(fieldName, codeDefId);

                    // Process the values for this definition
                    if (def.has("codeValues")) {
                        List<String> values = new ArrayList<>();
                        Map<String, Long> valueIds = new HashMap<>();

                        JsonNode codeValuesArray = def.get("codeValues");
                        logger.debug("Found {} code values for definition {}", codeValuesArray.size(), codeDefId);

                        // Prepare for CSV export if enabled
                        BufferedWriter csvWriter = null;
                        boolean dumpCsvFiles = false;
                        if (dumpCsvFiles && codeValuesArray.size() > 0) {
                            String safeFieldName = codeDefCode.replaceAll("[^a-zA-Z0-9_-]", "_");
                            String csvOutputDir = "";
                            String csvFileName = String.format("%s%s_%d.csv", csvOutputDir, safeFieldName, codeDefId);
                            try {
                                // Ensure parent directory exists
                                File csvFile = new File(csvFileName);
                                File parentDir = csvFile.getParentFile();
                                if (parentDir != null && !parentDir.exists()) {
                                    parentDir.mkdirs();
                                }

                                csvWriter = new BufferedWriter(new FileWriter(csvFileName));
                                // Write CSV header
                                csvWriter.write("code,id,description\n");
                                logger.info("Creating CSV file for definition {}: {}", codeDefCode, csvFileName);
                            } catch (IOException e) {
                                logger.error("Failed to create CSV file for {}: {}", codeDefCode, e.getMessage());
                                if (csvWriter != null) {
                                    try {
                                        csvWriter.close();
                                    } catch (IOException closeEx) {
                                        // Ignore
                                    }
                                    csvWriter = null;
                                }
                            }
                        }

                        for (JsonNode value : codeValuesArray) {
                            String code = value.get("code").asText();
                            long id = value.get("id").asLong();
                            values.add(code);
                            valueIds.put(code, id);
                            logger.debug("Added code value: {} -> {} for definition {}", code, id, codeDefId);

                            // Write to CSV if enabled
                            if (csvWriter != null) {
                                try {
                                    // Note: description may not be available in the new query format
                                    String description = value.has("description") && !value.get("description").isNull() && !value.get("description").asText().isEmpty() ?
                                            value.get("description").asText().replace(",", "\\,") : code;
                                    csvWriter.write(String.format("%s,%d,\"%s\"\n",
                                            code.replace(",", "\\,"), id, description));
                                } catch (IOException e) {
                                    logger.error("Error writing to CSV for {}: {}", codeDefCode, e.getMessage());
                                }
                            }
                        }

                        // Close CSV writer if open
                        if (csvWriter != null) {
                            try {
                                csvWriter.close();
                                logger.info("CSV file for definition {} completed", codeDefCode);
                            } catch (IOException e) {
                                logger.error("Error closing CSV file for {}: {}", codeDefCode, e.getMessage());
                            }
                        }

                        codeDefIdToValues.put(codeDefId, values);
                        codeDefIdToValueIds.put(codeDefId, valueIds);
                    }
                }
            }

            // Initialize the value transformer
            this.valueTransformer = new ValueTransformer(fieldNameToCodeDefId, codeDefIdToValueIds);

            // Log the field name mappings for debugging
            logger.info("Code list cache initialized with {} field mappings", fieldNameToCodeDefId.size());
            fieldNameToCodeDefId.forEach((key, value) -> {
                List<String> fieldValues = codeDefIdToValues.get(value);
                if (fieldValues != null) {
                    logger.debug("Field '{}' mapped to code definition ID {} with {} possible values: {}",
                            key, value, fieldValues.size(), fieldValues);
                } else {
                    logger.debug("Field '{}' mapped to code definition ID {} but no values are available",
                            key, value);
                }
            });

            initialized.set(true);
            logger.info("Code list cache initialization completed. Cached {} definitions", fieldNameToCodeDefId.size());
        } catch (Exception e) {
            logger.error("Failed to initialize code list cache", e);
           // throw new RuntimeException("Failed to initialize code list cache", e);
        }
    }

    /**
     * Retrieves code values for a specific code definition ID.
     *
     * @param codeDefId the ID of the code definition
     * @return the response as a JsonNode containing the code values
     * @throws IOException if an I/O error occurs
     */
    public JsonNode getCodeValues(long codeDefId) throws IOException {


        Map<String, Object> variables = new HashMap<>();
        variables.put("codeDefId", codeDefId);

        QueryDaoRequest queryDaoRequest = new QueryDaoRequest();
        queryDaoRequest.setQuery("query GetCodeValues($codeDefId: Long!) {\n" +
                "  codeValues(where: { codeDefId: { _eq: $codeDefId } }) {\n" +
                "    id\n" +
                "    code\n" +
                "    codeDefId\n" +
                "  }\n" +
                "}");
        queryDaoRequest.setVariables(variables);

        ConfigDataDaoResponse configDataDaoResponse = configDataDao.getConfig(queryDaoRequest);

        if(CollectionUtils.isNotEmpty(configDataDaoResponse.getErrors())){
            String errorDetails = configDataDaoResponse.getErrors().stream().map(GraphQlError::getMessage).collect(Collectors.joining());
            logger.error("getCodeValues: There are errors while fetching the config and hence returning error. Errors are {} ", errorDetails);

            throw new RuntimeException(errorDetails);
        }

        return objectMapper.valueToTree(configDataDaoResponse);
    }

    /**
     * Transforms a field name by removing underscores.
     * For example, "country_code" becomes "countrycode".
     *
     * @param fieldName the field name to transform
     * @return the transformed field name
     */
    private String transformFieldName(String fieldName) {
        return fieldName.replace("_", "");
    }

    /**
     * Retrieves all code list definitions.
     *
     * @return the response as a JsonNode containing all code list definitions
     * @throws IOException if an I/O error occurs
     */
    public JsonNode getCodeListDefinitions() throws IOException {
        logger.info("Retrieving all code list definitions");


        QueryDaoRequest queryDaoRequest = new QueryDaoRequest();
        queryDaoRequest.setQuery("query GetAllCodeDefsWithValues {\n" +
                "  codeDefs {\n" +
                "    id\n" +
                "    code\n" +
                "    codeValues {\n" +
                "      id\n" +
                "      code\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}");


        logger.info("Retrieving all code definitions with values in a single request");


        try {
            ConfigDataDaoResponse configDataDaoResponse = configDataDao.getConfig(queryDaoRequest);

            if (CollectionUtils.isNotEmpty(configDataDaoResponse.getErrors())) {
                String errorDetails = configDataDaoResponse.getErrors().stream().map(GraphQlError::getMessage).collect(Collectors.joining());
                logger.error("getCodeListDefinitions: There are errors while fetching the config and hence returning error. Errors are {} ", errorDetails);

                throw new RuntimeException(errorDetails);
            }


            return objectMapper.valueToTree(configDataDaoResponse);
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return null;
    }


    public Map<String, Long> getFieldNameToCodeDefId() {
        return fieldNameToCodeDefId;
    }

    public Map<Long, List<String>> getCodeDefIdToValues() {
        return codeDefIdToValues;
    }

    public Map<Long, Map<String, Long>> getCodeDefIdToValueIds() {
        return codeDefIdToValueIds;
    }

    public ValueTransformer getValueTransformer() {
        return valueTransformer;
    }

    public void setValueTransformer(ValueTransformer valueTransformer) {
        this.valueTransformer = valueTransformer;
    }
}

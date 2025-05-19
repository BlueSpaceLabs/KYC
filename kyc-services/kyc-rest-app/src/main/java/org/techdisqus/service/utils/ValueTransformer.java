package org.techdisqus.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class for transforming code values to their corresponding IDs.
 * This class handles the conversion of string code values to numeric IDs
 * based on the code definition mappings from the GraphQL API.
 */
public class ValueTransformer {
    private static final Logger logger = LoggerFactory.getLogger(ValueTransformer.class);
    
    // Map of field names to their code definition IDs
    private final Map<String, Long> fieldNameToCodeDefId;
    
    // Map of code definition IDs to their value-to-id mappings
    private final Map<Long, Map<String, Long>> codeDefIdToValueIds;
    
    // Special field mappings that need custom handling
    private static final Map<String, String> SPECIAL_FIELD_MAPPINGS;
    
    static {
        Map<String, String> mappings = new HashMap<>();
        mappings.put("sex", "gender");
        // Add any other special field mappings here
        SPECIAL_FIELD_MAPPINGS = Collections.unmodifiableMap(mappings);
    }
    
    /**
     * Creates a new ValueTransformer with the specified code mappings.
     * 
     * @param fieldNameToCodeDefId mapping of field names to code definition IDs
     * @param codeDefIdToValueIds mapping of code definition IDs to their value-to-id mappings
     */
    public ValueTransformer(Map<String, Long> fieldNameToCodeDefId, 
                          Map<Long, Map<String, Long>> codeDefIdToValueIds) {
        this.fieldNameToCodeDefId = new ConcurrentHashMap<>(fieldNameToCodeDefId);
        this.codeDefIdToValueIds = new ConcurrentHashMap<>(codeDefIdToValueIds);
    }
    
    /**
     * Transforms a map of applicant details by converting code values to their corresponding IDs.
     * 
     * @param details The original details map
     * @return A new map with transformed values
     */
    public Map<String, Object> transformValues(Map<String, Object> details) {
        Map<String, Object> transformed = new HashMap<>();
        
        logger.debug("=== Starting Value Transformation ===");
        
        details.forEach((key, value) -> {
            if (value instanceof String) {
                transformStringValue(key, (String)value, transformed);
            } else {
                // Non-string values are passed through unchanged
                transformed.put(key, value);
                logger.debug("No transformation for field='{}' (not a string value)", key);
            }
        });
        
        logger.debug("=== Value Transformation Complete ===");
        if (logger.isDebugEnabled()) {
            logger.debug("Transformed values: {}", transformed);
        }
        
        return transformed;
    }
    
    /**
     * Transforms a string value based on code definitions.
     * 
     * @param key The field name
     * @param stringValue The string value to transform
     * @param transformed The map to store the transformed value
     */
    private void transformStringValue(String key, String stringValue, Map<String, Object> transformed) {
        logger.debug("Processing field: '{}' with value: '{}'", key, stringValue);
        
        // Normalize key to match how it's stored in the map (lowercase, no underscores)
        String normalizedKey = normalizeKey(key);
        
        // Apply special field mappings if needed
        normalizedKey = applySpecialFieldMapping(normalizedKey);
        
        // Log special cases for debugging
        logSpecialCases(normalizedKey, stringValue);
        
        // Get the code definition ID for this field
        Long codeDefId = fieldNameToCodeDefId.get(normalizedKey.toUpperCase());
        logger.debug("Normalized key: '{}', Code def ID: {}", normalizedKey, codeDefId);
        
        if (codeDefId != null) {
            transformCodeField(key, stringValue, codeDefId, transformed, normalizedKey);
        } else {
            // Not a code field, pass through unchanged
            transformed.put(key, stringValue);
            logger.debug("No transformation for field='{}' (not a code field)", key);
        }
    }
    
    /**
     * Transforms a field that has a code definition.
     */
    private void transformCodeField(String key, String stringValue, Long codeDefId, 
                                   Map<String, Object> transformed, String normalizedKey) {
        // Get the value-to-id mapping for this code definition
        Map<String, Long> valueIds = codeDefIdToValueIds.getOrDefault(codeDefId, Collections.emptyMap());
        
        // Log value IDs for special cases
        if (isSpecialLoggingCase(normalizedKey)) {
            logger.info("{} code def ID: {}, value IDs: {}", 
                    normalizedKey, codeDefId, valueIds);
        }
        
        logger.debug("Value IDs for code def ID {}: {}", codeDefId, valueIds);
        
        // Transform the value if it exists in the mapping
        if (!valueIds.isEmpty() && valueIds.containsKey(stringValue.toUpperCase())) {
            Long id = valueIds.get(stringValue.toUpperCase());
            transformed.put(key, id);
            logger.debug("Transformed: field='{}' value='{}' -> id={}", key, stringValue, id);
        } else {
            // Value not found in mapping, pass through unchanged
            transformed.put(key, stringValue);
            logTransformationFailure(key, stringValue, valueIds);
        }
    }
    
    /**
     * Normalizes a key by converting to lowercase and removing underscores.
     */
    private String normalizeKey(String key) {
        return key.toLowerCase().replace("_", "");
    }
    
    /**
     * Applies special field mappings for certain fields.
     */
    private String applySpecialFieldMapping(String normalizedKey) {
        return SPECIAL_FIELD_MAPPINGS.getOrDefault(normalizedKey, normalizedKey);
    }
    
    /**
     * Logs special cases for debugging.
     */
    private void logSpecialCases(String normalizedKey, String stringValue) {
        if (isSpecialLoggingCase(normalizedKey)) {
            logger.info("Processing {} field with value: '{}', normalized key: '{}'", 
                    normalizedKey, stringValue, normalizedKey);
        }
    }
    
    /**
     * Determines if a field needs special logging.
     */
    private boolean isSpecialLoggingCase(String normalizedKey) {
        return normalizedKey.equals("registrationtype") || 
               normalizedKey.equals("transactiontype") || 
               normalizedKey.equals("updatetype");
    }
    
    /**
     * Logs transformation failures with appropriate warning level.
     */
    private void logTransformationFailure(String key, String stringValue, Map<String, Long> valueIds) {
        if (!valueIds.isEmpty()) {
            logger.warn("No transformation for field='{}' value='{}' (code not found in mapping). Available values: {}", 
                    key, stringValue, valueIds.keySet());
        } else {
            logger.warn("No transformation for field='{}' value='{}' (no values defined for code definition)", 
                    key, stringValue);
        }
    }
} 
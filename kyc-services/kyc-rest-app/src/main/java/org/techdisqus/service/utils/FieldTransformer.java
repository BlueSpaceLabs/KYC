package org.techdisqus.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for transforming field names for InternalApi API.
 */
public class FieldTransformer {
    private static final Logger logger = LoggerFactory.getLogger(FieldTransformer.class);
    private static final Map<String, String> FIELD_MAPPINGS = new HashMap<>();
    private static final Map<String, String> NORMALIZED_MAPPINGS = new HashMap<>();
    
    static {
        // Code fields - require ctv prefix
        FIELD_MAPPINGS.put("countryCode", "ctvCountryCode");
        FIELD_MAPPINGS.put("documentType", "ctvDocumentType");
        FIELD_MAPPINGS.put("education", "ctvEducation");
        FIELD_MAPPINGS.put("encounterMissionType", "ctvEncounterMissionType");
        FIELD_MAPPINGS.put("nationality", "ctvNationality");
        FIELD_MAPPINGS.put("profession", "ctvProfession");
        FIELD_MAPPINGS.put("racialCharacteristic", "ctvRacialCharacteristic");
        FIELD_MAPPINGS.put("registrationType", "ctvRegistrationType");
        FIELD_MAPPINGS.put("sex", "ctvSex");
        FIELD_MAPPINGS.put("transactionType", "ctvTransactionType");
        FIELD_MAPPINGS.put("updateType", "ctvUpdateType");
        
        // Lowercase variants of code fields
        FIELD_MAPPINGS.put("registrationtype", "ctvRegistrationType");
        FIELD_MAPPINGS.put("transactiontype", "ctvTransactionType");
        FIELD_MAPPINGS.put("updatetype", "ctvUpdateType");
        FIELD_MAPPINGS.put("countrycode", "ctvCountryCode");
        FIELD_MAPPINGS.put("documenttype", "ctvDocumentType");
        FIELD_MAPPINGS.put("encountermiisiontype", "ctvEncounterMissionType");
        FIELD_MAPPINGS.put("racialcharacteristic", "ctvRacialCharacteristic");
        
        // National language fields - require Nl suffix
        FIELD_MAPPINGS.put("dateOfBirthNationalLanguage", "dateOfBirthNl");
        FIELD_MAPPINGS.put("givenNamesNationalLanguage", "givenNamesNl");
        FIELD_MAPPINGS.put("mothersNameNationalLanguage", "mothersNameNl");
        FIELD_MAPPINGS.put("documentTypeNationalLanguage", "documentTypeNl");
        FIELD_MAPPINGS.put("surnameNationalLanguage", "surnameNl");
        FIELD_MAPPINGS.put("sexNationalLanguage", "sexNl");
        FIELD_MAPPINGS.put("dateOfExpiryNationalLanguage", "dateOfExpiryNl");
        FIELD_MAPPINGS.put("dateOfIssueNationalLanguage", "dateOfIssueNl");
        FIELD_MAPPINGS.put("fathersNameNationalLanguage", "fathersNameNl");
        FIELD_MAPPINGS.put("fullNameNationalLanguage", "fullNameNl");
        FIELD_MAPPINGS.put("professionNationalLanguage", "professionNl");
        FIELD_MAPPINGS.put("nationalityNationalLanguage", "nationalityNl");
        FIELD_MAPPINGS.put("notesNationalLanguage", "notesNl");
        FIELD_MAPPINGS.put("personalNumberNationalLanguage", "personalNumberNl");
        FIELD_MAPPINGS.put("placeOfBirthNationalLanguage", "placeOfBirthNl");
        FIELD_MAPPINGS.put("drivingCategoriesNationalLanguage", "drivingCategoriesNl");
        
        // Populate normalized mappings for case-insensitive lookup
        FIELD_MAPPINGS.forEach((key, value) -> 
            NORMALIZED_MAPPINGS.put(normalizeKey(key), value));
    }
    
    /**
     * Normalizes a key by converting to lowercase and removing underscores and spaces.
     */
    private static String normalizeKey(String key) {
        return key.toLowerCase().replace("_", "").replace(" ", "");
    }
    
    /**
     * Transforms a map of applicant details by applying field name mappings.
     * 
     * @param details The original details map
     * @return A new map with transformed field names
     */
    public static Map<String, Object> transformFields(Map<String, Object> details) {
        Map<String, Object> transformed = new HashMap<>();
        
        logger.debug("=== Starting Field Name Transformation ===");
        logger.debug("Field mappings: {}", FIELD_MAPPINGS);
        logger.debug("Normalized mappings: {}", NORMALIZED_MAPPINGS);
        
        details.forEach((key, value) -> {
            logger.debug("Processing field: '{}' with value: '{}'", key, value);
            
            // First try exact match
            String transformedKey = FIELD_MAPPINGS.getOrDefault(key, null);
            logger.debug("Exact match for '{}': {}", key, transformedKey);
            
            // If no exact match, try normalized match
            if (transformedKey == null) {
                String normalizedKey = normalizeKey(key);
                logger.debug("Normalized key: '{}'", normalizedKey);
                
                transformedKey = NORMALIZED_MAPPINGS.getOrDefault(normalizedKey, key);
                logger.debug("Normalized match for '{}': {}", normalizedKey, transformedKey);
                
                if (!key.equals(transformedKey)) {
                    logger.debug("Field name normalized and transformed: '{}' -> '{}'", key, transformedKey);
                }
            } else {
                logger.debug("Field name transformed: '{}' -> '{}'", key, transformedKey);
            }
            
            if (value != null) {
                transformed.put(transformedKey, value);
                logger.debug("Added to transformed map: '{}' -> '{}'", transformedKey, value);
            }
        });
        
        logger.debug("=== Field Name Transformation Complete ===");
        logger.debug("Transformed field names: {}", transformed.keySet());
        
        return transformed;
    }
} 
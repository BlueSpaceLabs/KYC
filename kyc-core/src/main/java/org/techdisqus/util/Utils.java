package org.techdisqus.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class Utils {

    public static Map<String, String> parseInfo(String requestInformation) {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        String str = encryptionUtil.decrypt(requestInformation);
        try {
            return new ObjectMapper().readValue(str, new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize decrypted userData", e);
        }
    }
}

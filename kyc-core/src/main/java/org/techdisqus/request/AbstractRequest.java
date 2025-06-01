package org.techdisqus.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.techdisqus.util.ApplicationContextUtils;
import org.techdisqus.util.EncryptionUtil;

import java.util.Map;

@Data
public abstract class AbstractRequest {

    private String accountIdentifier;

    private String requestInformation;

    private String requestId;

    private String locale;

    public String getRequestInformationString(){
        return requestInformation;
    }
    public Map<String, String> getRequestInformation() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        String str = encryptionUtil.decrypt(requestInformation);
        try {
            return new ObjectMapper().readValue(str, new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize decrypted userData", e);
        }
    }

    public void setRequestInformation(Map<String, String> map) {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        try {
            String json = new ObjectMapper().writeValueAsString(map);
            this.requestInformation =  encryptionUtil.encrypt(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setRequestInformation(String requestInformation) {
        this.requestInformation = requestInformation;
    }
}

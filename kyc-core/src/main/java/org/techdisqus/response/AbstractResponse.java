package org.techdisqus.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.context.ApplicationContext;
import org.techdisqus.util.ApplicationContextUtils;
import org.techdisqus.util.EncryptionUtil;

import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AbstractResponse {

    private String errorCode;
    private String errorDetails;
    private String userData;
    private String requestId;
    private String spanId;

    public void setUserData(Map<String, String> map) {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        try {
            String json = new ObjectMapper().writeValueAsString(map);
            this.userData =  encryptionUtil.encrypt(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @JsonIgnore
    public boolean isSuccess(){
        return errorCode != null;
    }
}

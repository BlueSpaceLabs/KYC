package org.techdisqus.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.context.ApplicationContext;
import org.techdisqus.util.ApplicationContextUtils;
import org.techdisqus.util.EncryptionUtil;

import java.util.Map;

@Data
@SuperBuilder
public class AbstractResponse {

    private String errorCode;
    private String errorDetails;
    private String userData;
    private String requestId;
    private String spanId;

    public void setUserData(Map<String, String> map) {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        this.userData = encryptionUtil.decrypt(map.toString());
    }

    public boolean isSuccess(){
        return errorCode != null;
    }
}

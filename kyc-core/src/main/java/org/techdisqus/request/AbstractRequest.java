package org.techdisqus.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.techdisqus.util.ApplicationContextUtils;
import org.techdisqus.util.EncryptionUtil;

import java.util.Map;

@Data
public abstract class AbstractRequest {

    private String requestInformation;

    private String requestId;

    private String locale;

    public Map<String, String> getRequestInformation() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        String str = encryptionUtil.decrypt(requestInformation);
        return new ObjectMapper().convertValue(str, Map.class);
    }

    public void setRequestInformation(Map<String, String> map) {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        EncryptionUtil encryptionUtil = context.getBean(EncryptionUtil.class);
        requestInformation = encryptionUtil.decrypt(map.toString());
    }
}

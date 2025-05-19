package org.techdisqus.config;

import com.innovatrics.dot.integrationsamples.disapi.ApiClient;
import com.innovatrics.dot.integrationsamples.disapi.model.CustomerOnboardingApi;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.client.RestClient;
import org.techdisqus.service.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.techdisqus.util.EncryptionCredentials;

import java.io.IOException;

@Configuration
public class Config {

    @Bean(name = "encryptionCredentials")
    public EncryptionCredentials getEncryptionCredentials() {
        EncryptionCredentials credentials =  new EncryptionCredentials("GlB1^5^1obef1&11","GbeInitmreVector");
        return credentials;
    }

    @Bean(name = "customerOnboardingApi")
    public CustomerOnboardingApi customerOnboardingApi(){
        final org.techdisqus.config.Configuration configuration;
        try {
            configuration = new org.techdisqus.config.Configuration();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final ApiClient client = new ApiClient().setBasePath(configuration.DOT_IDENTITY_SERVICE_URL);
        client.setBearerToken(configuration.DOT_AUTHENTICATION_TOKEN);
        return  new CustomerOnboardingApi(client);
    }

    @Bean
    public MessageProvider messageProvider(){
        MessageProvider messageProvider = new MessageProvider("en");
        return messageProvider;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages"); // without the .properties
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean("disClient")
    public RestClient disClient() {
        return RestClient.builder()
                 .baseUrl("https://dot.innovatrics.com/identity").build();
    }

    @Bean("trustPlatformClient")
    public RestClient trustPlatformClient() {
        return RestClient.builder()
                .baseUrl("https://dot.innovatrics.com/identity").build();
    }

    @Bean("token")
    public String token(){
        return "RElTX2V2YWxfNTA5Ok9wMmMwY2Q0bVBvSHFqb2RQS1hmR2ZkSmx4WXp5MXhT";
    }
}

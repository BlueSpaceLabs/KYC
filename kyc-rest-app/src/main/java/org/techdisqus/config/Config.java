package org.techdisqus.config;

import com.innovatrics.dot.integrationsamples.disapi.ApiClient;
import com.innovatrics.dot.integrationsamples.disapi.model.CustomerOnboardingApi;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestClient;
import org.techdisqus.service.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.techdisqus.util.EncryptionCredentials;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

        OkHttpClient productionHttpClient = getOkHttpClient();

        final ApiClient client = new ApiClient().setHttpClient(productionHttpClient).setBasePath(configuration.DOT_IDENTITY_SERVICE_URL);
        client.setBearerToken(configuration.DOT_AUTHENTICATION_TOKEN);

        return  new CustomerOnboardingApi(client);
    }

    @NotNull
    @Bean
    private static OkHttpClient getOkHttpClient() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(500);
        executor.initialize();
        ExecutorService executorService = Executors.newCachedThreadPool(executor);
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)          // Establishing connection
                .readTimeout(30, TimeUnit.SECONDS)             // Waiting for server response
                .writeTimeout(15, TimeUnit.SECONDS)            // Uploading request body
                .retryOnConnectionFailure(true)                // Retry once on failure
                .connectionPool(new ConnectionPool(50, 5, TimeUnit.MINUTES))  // Reuse TCP connections
                .addInterceptor(new OkHttpHeaderInjector())    // Your interceptor for headers
                .addInterceptor(new TimingInterceptor())
                .dispatcher(new Dispatcher(new ContextAwareExecutorService(executorService)))
                .build();
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
        return "RElTX2V2YWxfNTM5OndZckxOM0dMQnZjMUVVRlNVbHdXcGVyMlJYNE1DVXlX";
    }
}

package org.techdisqus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.techdisqus.config.logging.api.ApiLoggingInterceptor;
import org.techdisqus.config.logging.api.RequestHeaderInterceptor;
import org.techdisqus.request.HeaderInfoArgumentResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ApiLoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private RequestHeaderInterceptor requestHeaderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(requestHeaderInterceptor);
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new HeaderInfoArgumentResolver());
    }
}
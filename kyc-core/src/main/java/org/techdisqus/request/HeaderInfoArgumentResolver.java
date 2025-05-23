package org.techdisqus.request;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HeaderInfoArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return KycRequestHeaders.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String accountIdentifier = webRequest.getHeader("x-accountIdentifier");
        String requestInformation = webRequest.getHeader("x-requestInformation");
        String locale = webRequest.getHeader("x-locale");

        return  KycRequestHeaders.builder().requestInformation(requestInformation)
                .accountIdentifier(accountIdentifier).locale(locale).build();
    }
}

package org.techdisqus.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtilities {

    public static <T> Result<String>  toJsonString(T t) {
        try {
            return new Result<>(getObjectMapper().writeValueAsString(t), true);
        }catch (JsonProcessingException e) {
            return new Result<>(e, false);
        }
    }

    public static <T> Result<T> toObject(String json, Class<T> to) {
        try {
            return new Result<>(getObjectMapper().convertValue(json, to ), true);
        }catch (Exception e) {
            return new Result<>(e.getCause(), false);
        }
    }

    private static ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}

package com.app.person.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

public class JsonUtil {

    public static Object jsonToObject(String json, Class c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if(c.isArray()){
            return Arrays.asList(mapper.readValue(json, Object[].class));
        }
        return mapper.readValue(json, c);
    }
}

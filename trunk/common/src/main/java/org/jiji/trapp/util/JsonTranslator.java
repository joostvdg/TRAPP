package org.jiji.trapp.util;

import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.jiji.trapp.dto.AbstractJsonDto;

/**
 * User: Joost van der Griendt
 * Date: 8/17/13
 * Time: 12:24 AM
 */
public class JsonTranslator {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationConfig.Feature.AUTO_DETECT_FIELDS, true);
        mapper.configure(DeserializationConfig.Feature.AUTO_DETECT_SETTERS, true);
        mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
    }

    public static final String objectToJson(Object jsonDto) throws IOException {
        return mapper.writeValueAsString(jsonDto);
    }

    public static final AbstractJsonDto jsonToObject(String json, Class<? extends AbstractJsonDto> clasz) throws IOException {
        return mapper.readValue(json, clasz);
    }

    public static final AbstractJsonDto jsonToObject(InputStream source, Class<? extends AbstractJsonDto> clasz) throws IOException {
        return mapper.readValue(source, clasz);
    }

}

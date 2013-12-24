package org.jiji.trapp.web.config;

import javax.ws.rs.ext.ContextResolver;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Serialization settings for Jackson.
 */
public class JacksonSetup implements ContextResolver<ObjectMapper>
{

    private final ObjectMapper mapper;

    public JacksonSetup() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

}
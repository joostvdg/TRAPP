package org.jiji.trapp.web.config;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author J van der Griendt
 * @author iColumbo@IRN
 * 
 */
@Configuration
@ComponentScan("org.jiji.trapp")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class WebMvcConfiguration extends WebMvcConfigurationSupport
{

    @SuppressWarnings("unused")
    private ApplicationContext applicationContext;

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#configureMessageConverters(java.util.List)
     */
    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        ObjectMapper objectMapper = buildObjectMapper();
        converter.setObjectMapper(objectMapper);
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        converters.add(converter);
    }

    /**
     * @return
     */
    @Bean
    @Qualifier("objectMapper")
    public ObjectMapper buildObjectMapper() {
        ObjectMapper objectMapper = buildCommonObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
        return objectMapper;
    }

    @Bean
    @Qualifier("documentObjectMapper")
    public ObjectMapper buildDocumentObjectMapper() {
        ObjectMapper objectMapper = buildCommonObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
        return objectMapper;
    }

    @Bean
    public ClientHttpRequestFactory createClientHttpRequestFactory() {
        return new SimpleClientHttpRequestFactory();
    }

    private ObjectMapper buildCommonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);

        Version version = new Version(1, 0, 0, "SNAPSHOT");
        SimpleModule module = new SimpleModule("iso8601Serializer", version);
        module = module.addSerializer(new Iso8601Serializer());
        objectMapper.registerModule(module);

        return objectMapper;
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
}

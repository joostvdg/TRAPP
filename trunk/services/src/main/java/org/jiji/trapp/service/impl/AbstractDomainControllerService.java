package org.jiji.trapp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jiji.trapp.JsonTranslator;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.AbstractJsonDto;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.service.DomainControllerService;
import org.jiji.trapp.service.RedisService;
import org.jiji.trapp.service.translate.Translator;
import org.jiji.trapp.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.inject.Inject;

/**
 * @author J van der Griendt
 *
 * @param <T> dto for the domain object
 * @param <D> the domain object
 */
@Transactional
public abstract class AbstractDomainControllerService<T extends AbstractJsonDto, D extends ModelBase> implements
        DomainControllerService<T, D>
{

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDomainControllerService.class);

    private Translator<T, D> translator;

    private JpaRepository<D, Long> repository;

    @Inject
    private RedisService redisService;

    private final Class<T> dtoClass;

    private final Class<D> domainClass;

    AbstractDomainControllerService(){
        domainClass = getDomainClass();
        dtoClass = getDtoClass();
    }

    protected void setTranslator(Translator<T, D> translator) {
        this.translator = translator;
    }

    protected Translator<T, D> getTranslator() {
        return translator;
    }

    protected void setRepository(JpaRepository<D, Long> repository) {
        this.repository = repository;
    }

    protected JpaRepository<D, Long> getRespository() {
        return repository;
    }

    @Override
    public List<T> getAllForExport() {
        List<T> domainObjectDtos = new ArrayList<>();
        List<D> domainObjectList = repository.findAll();

        for (D d : domainObjectList) {
            T t = translator.translate(d);
            domainObjectDtos.add(t);
        }

        return domainObjectDtos;
    }

    @Override
    public T getExportById(Long id) throws IOException {
        StopWatch watch = new StopWatch("retreiveUser");
        watch.start();
        String key = RedisUtil.generateKeyForClass(domainClass, id);

        if (redisService.isAvailable()) {
            String jsonBody = redisService.get(key);
            if (jsonBody != null ) {
                watch.stop();
                LOG.debug("jsonBody retrieved:{}", jsonBody);
                LOG.info("retreived {} from redis: {}",  domainClass.getSimpleName(), watch.prettyPrint());
                return (T) JsonTranslator.jsonToObject(jsonBody, dtoClass);
            }
        }

        D d = repository.findOne(id);
        T t = null;
        if (d != null) {
            t = translator.translate(d);
        }

        if (redisService.isAvailable()) {
            String jsonBody = JsonTranslator.objectToJson(t);
            LOG.debug("jsonBody going in:{}", jsonBody);
            redisService.set(key, jsonBody);
        }

        watch.stop();
        LOG.info("retrieved {} from db: {}", domainClass.getSimpleName(),watch.prettyPrint());

        return t;
    }

    @Override
    public D getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public String addNew(InputStream inputStream) throws IOException {
        String jsonBody = IOUtils.toString(inputStream, "UTF-8");
        T t = (T) JsonTranslator.jsonToObject(jsonBody, dtoClass);
        D d = translator.translate(t);
        return addNew(d, jsonBody);
    }

    @Override
    public String addNew(D d, String jsonBody) throws IOException {
        StopWatch watch = new StopWatch("store");
        String storingStyle = "db";
        watch.start();

        if (d.isDraft() && redisService.isAvailable()){
            if (d.getCreated() == null ) {
                d.setCreated(new Date());
            }

            String key = RedisUtil.generateKeyForClass(domainClass, d.getCreated().getTime());
            redisService.set(key, jsonBody);
            storingStyle = "redis";
        } else {
            if (d instanceof User)
                LOG.info("Saving user with email " + ((User) d).getEmail());
            d = repository.saveAndFlush(d);
        }
        T t = translator.translate(d);
        watch.stop();
        LOG.info(String.format("Storing %s in %s: %s", domainClass.getSimpleName(),storingStyle,watch.prettyPrint()));
        return JsonTranslator.objectToJson(t);
    }
}

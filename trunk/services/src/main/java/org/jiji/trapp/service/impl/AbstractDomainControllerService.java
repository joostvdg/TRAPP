package org.jiji.trapp.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jiji.trapp.JsonTranslator;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;
import org.jiji.trapp.service.DomainControllerService;
import org.jiji.trapp.service.RedisService;
import org.jiji.trapp.service.translate.Translator;
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
        String className = domainClass.getSimpleName();
        String key = className+id;
        String jsonBody = redisService.get(key);
        if (jsonBody != null ) {
            watch.stop();
            LOG.debug("jsonBody retrieved:{}", jsonBody);
            LOG.info("retreived {} from redis: {}",  className, watch.prettyPrint());
            return (T) JsonTranslator.jsonToObject(jsonBody, dtoClass);
        }

        D d = repository.findOne(id);
        T t = null;
        if (d != null) {
            t = translator.translate(d);
        }
        jsonBody = JsonTranslator.objectToJson(t);
        LOG.debug("jsonBody going in:{}", jsonBody);
        redisService.set(key, jsonBody);
        watch.stop();
        LOG.info("retreived {} from db: {}", className,watch.prettyPrint());

        return t;
    }

    @Override
    public D getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void addNew(T t) {
        D d = translator.translate(t);
        repository.saveAndFlush(d);
    }
}

package org.jiji.trapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;
import org.jiji.trapp.service.DomainControllerService;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author J van der Griendt
 * 
 * @param <T>
 * @param <D>
 */
@Transactional
public abstract class AbstractDomainControllerService<T extends AbstractJsonDto, D extends ModelBase> implements
        DomainControllerService<T, D>
{

    private Translator<T, D> translator;

    private JpaRepository<D, Long> repository;

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
    public T getExportById(Long id) {
        D d = repository.findOne(id);
        T t = null;

        if (d != null) {
            t = translator.translate(d);
        }

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

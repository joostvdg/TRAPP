package org.jiji.trapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author J van der Griendt
 * 
 * @param <T>
 * @param <D>
 */
public abstract class AbstractDomainControllerService<T extends AbstractJsonDto, D extends ModelBase>
{

    private Translator<T, D> translator;

    private JpaRepository<D, Long> repository;

    protected void setTranslator(Translator<T, D> translator) {
        this.translator = translator;
    }

    protected void setRepository(JpaRepository<D, Long> repository) {
        this.repository = repository;
    }

    public List<T> getAllForExport() {
        List<T> domainObjectDtos = new ArrayList<>();
        List<D> domainObjectList = repository.findAll();

        for (D d : domainObjectList) {
            T t = translator.translate(d);
            domainObjectDtos.add(t);
        }

        return domainObjectDtos;
    }

    public T getById(Long id) {
        D d = repository.findOne(id);
        T t = null;

        if (d != null) {
            t = translator.translate(d);
        }

        return t;
    }

    public void addNew(T t) {
        D d = translator.translate(t);
        repository.saveAndFlush(d);
    }
}

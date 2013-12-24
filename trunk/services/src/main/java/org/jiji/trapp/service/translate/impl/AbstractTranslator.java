package org.jiji.trapp.service.translate.impl;

import java.util.Date;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;

/**
 * User: Joost van der Griendt
 * Date: 8/19/13
 * Time: 10:24 PM
 */
public abstract class AbstractTranslator<T extends AbstractJsonDto, D extends ModelBase>
{

    public T translateBaseFromDomainToDto(D d, T t) {
        Long id = d.getId();
        int version = d.getVersion();
        boolean isDraft = d.isDraft() == null ? true : d.isDraft();
        Date created = d.getCreated();

        t.setId(id);
        t.setVersion(version);
        t.setDraft(isDraft);
        t.setCreated(created);

        return t;
    }

    public D translateBaseFromDtoToDomain(T t, D d) {
        Long id = t.getId();
        int version = t.getVersion();
        boolean isDraft = t.isDraft();
        Date created = t.getCreated();

        d.setId(id);
        d.setVersion(version);
        d.setDraft(isDraft);
        d.setCreated(created);
        return d;
    }

}

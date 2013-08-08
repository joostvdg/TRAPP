package org.jiji.trapp.service.translate;

import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author J van der Griendt
 * 
 * @param <T>
 *            Json Dto coressponding to the Domain object D
 * @param <D>
 *            Domain object
 */
@Transactional
public interface Translator<T extends AbstractJsonDto, D extends ModelBase>
{
    T translate(D d);

    D translate(T t);
}

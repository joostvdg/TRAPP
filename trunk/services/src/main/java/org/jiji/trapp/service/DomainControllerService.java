package org.jiji.trapp.service;

import java.util.List;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;

/**
 * @author J van der Griendt
 * 
 */
public interface DomainControllerService<T extends AbstractJsonDto, D extends ModelBase>
{
    public List<T> getAllForExport();

    public T getById(Long id);

    public void addNew(T t);

}

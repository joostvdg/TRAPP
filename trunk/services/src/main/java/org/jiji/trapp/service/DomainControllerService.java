package org.jiji.trapp.service;

import java.io.IOException;
import java.util.List;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;

/**
 * @author J van der Griendt
 * 
 */
public interface DomainControllerService<T extends AbstractJsonDto, D extends ModelBase>
{

    Class<T> getDtoClass();

    Class<D> getDomainClass();

    List<T> getAllForExport();

    T getExportById(Long id) throws IOException;

    D getById(Long id);

    void addNew(T t);

}

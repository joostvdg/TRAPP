package org.jiji.trapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.jiji.trapp.domain.ModelBase;
import org.jiji.trapp.dto.AbstractJsonDto;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.dto.UserDto;

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

    String addNew(T t, InputStream inputStream) throws IOException;

    String addNew(D d, InputStream inputStream) throws IOException;
}

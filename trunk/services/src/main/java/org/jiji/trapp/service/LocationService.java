package org.jiji.trapp.service;

import org.jiji.trapp.domain.Location;
import org.jiji.trapp.dto.LocationDto;

/**
 * @author J van der Griendt
 * 
 */
public interface LocationService extends DomainControllerService<LocationDto, Location>
{

    String[] getAllLocationTypes();

}

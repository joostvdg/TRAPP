package org.jiji.trapp.service;

import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.dto.TravellerDto;

/**
 * @author J van der Griendt
 * 
 */
public interface TravellerService extends DomainControllerService<TravellerDto, Traveller>
{

    String[] getAllTravellerRoles();

}

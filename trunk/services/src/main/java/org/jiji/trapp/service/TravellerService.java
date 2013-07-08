package org.jiji.trapp.service;

import java.util.Set;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.dto.TravellerDto;

/**
 * @author J van der Griendt
 * 
 */
public interface TravellerService extends DomainControllerService<TravellerDto, Traveller>
{

    String[] getAllTravellerRoles();

    Traveller getActualTraveller(Traveller organizer);

    Set<Traveller> getActualTravellersList(Set<Traveller> travellers);

}

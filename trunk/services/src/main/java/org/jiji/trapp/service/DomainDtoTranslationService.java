package org.jiji.trapp.service;

import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.Travel;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.domain.Trip;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.dto.UserDto;

/**
 * @author J van der Griendt
 * 
 */
public interface DomainDtoTranslationService
{
    UserDto translateUser(User user);

    User translateUser(UserDto userDto);

    LocationDto translateLocation(Location location);

    Location translateLocation(LocationDto locationDto);

    TravellerDto translateTraveller(Traveller traveller);

    Traveller translateTraveller(TravellerDto travellerDto);

    TravelDto translateTravel(Travel travel);

    Travel translateTravel(TravelDto travelDto);

    TripDto translateTrip(Trip trip);

    Trip translateTrip(TripDto tripDto);
}

package org.jiji.trapp.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.Travel;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.domain.Trip;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.domain.enums.LocationType;
import org.jiji.trapp.domain.enums.TravellerRole;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.DomainDtoTranslationService;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class DomainDtoTranslationServiceImpl implements DomainDtoTranslationService
{

    @Override
    public UserDto translateUser(User user) {
        Long id = user.getId();
        String name = user.getName();
        String surnamePrefix = user.getSurnamePrefix();
        String surname = user.getSurname();
        String email = user.getEmail();

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setSurnamePrefix(surnamePrefix);
        userDto.setSurname(surname);
        userDto.setEmail(email);

        return userDto;
    }

    @Override
    public User translateUser(UserDto userDto) {
        String name = userDto.getName();
        String surnamePrefix = userDto.getSurnamePrefix();
        String surname = userDto.getSurname();
        String email = userDto.getEmail();

        User user = new User();
        user.setName(name);
        user.setSurnamePrefix(surnamePrefix);
        user.setSurname(surname);
        user.setEmail(email);
        return user;
    }

    @Override
    public LocationDto translateLocation(Location location) {
        Long id = location.getId();
        String name = location.getName();
        String description = location.getDescription();
        String locationType = location.getLocationType().name();

        LocationDto locationDto = new LocationDto();
        locationDto.setId(id);
        locationDto.setName(name);
        locationDto.setDescription(description);
        locationDto.setLocationType(locationType);

        return locationDto;
    }

    @Override
    public Location translateLocation(LocationDto locationDto) {
        Long id = locationDto.getId();
        String name = locationDto.getName();
        String description = locationDto.getDescription();
        LocationType locationType = LocationType.valueOf(locationDto.getLocationType());

        Location location = new Location();
        location.setId(id);
        location.setName(name);
        location.setDescription(description);
        location.setLocationType(locationType);

        return location;
    }

    @Override
    public TravellerDto translateTraveller(Traveller traveller) {
        Long id = traveller.getId();
        String travellerRole = traveller.getTravellerRole().name();
        UserDto user = translateUser(traveller.getUser());

        TravellerDto travellerDto = new TravellerDto();
        travellerDto.setId(id);
        travellerDto.setTravellerRole(travellerRole);
        travellerDto.setUser(user);

        return travellerDto;
    }

    @Override
    public Traveller translateTraveller(TravellerDto travellerDto) {
        Long id = travellerDto.getId();
        TravellerRole travellerRole = TravellerRole.valueOf(travellerDto.getTravellerRole());
        User user = translateUser(travellerDto.getUser());

        Traveller traveller = new Traveller();
        traveller.setId(id);
        traveller.setTravellerRole(travellerRole);
        traveller.setUser(user);
        return traveller;
    }

    @Override
    public TravelDto translateTravel(Travel travel) {
        Long id = travel.getId();
        String name = travel.getName();
        String description = travel.getDescription();
        LocationDto location = translateLocation(travel.getLocation());
        TravellerDto organizer = translateTraveller(travel.getOrganizer());
        List<TravellerDto> travellers = translateTravellers(travel.getTravellers());

        TravelDto travelDto = new TravelDto();
        travelDto.setId(id);
        travelDto.setName(name);
        travelDto.setDescription(description);
        travelDto.setLocation(location);
        travelDto.setOrganizer(organizer);
        travelDto.setTravellers(travellers);
        return travelDto;
    }

    private List<TravellerDto> translateTravellers(Set<Traveller> travellers) {
        List<TravellerDto> travellerDtos = new ArrayList<>();

        for (Traveller traveller : travellers) {
            travellerDtos.add(translateTraveller(traveller));
        }

        return travellerDtos;
    }

    @Override
    public Travel translateTravel(TravelDto travelDto) {
        Long id = travelDto.getId();
        String name = travelDto.getName();
        String description = travelDto.getDescription();
        Location location = translateLocation(travelDto.getLocation());
        Traveller organizer = translateTraveller(travelDto.getOrganizer());
        Set<Traveller> travellers = translateTravellers(travelDto.getTravellers());

        Travel travel = new Travel();
        travel.setId(id);
        travel.setName(name);
        travel.setDescription(description);
        travel.setLocation(location);
        travel.setOrganizer(organizer);
        travel.setTravellers(travellers);

        return travel;
    }

    private Set<Traveller> translateTravellers(List<TravellerDto> travellerDtos) {
        Set<Traveller> travellers = new HashSet<>();
        for (TravellerDto travellerDto : travellerDtos) {
            Traveller traveller = translateTraveller(travellerDto);
            travellers.add(traveller);
        }
        return travellers;
    }

    @Override
    public TripDto translateTrip(Trip trip) {
        Long id = trip.getId();
        String name = trip.getName();
        String description = trip.getDescription();
        LocationDto location = translateLocation(trip.getLocation());
        TravellerDto organizer = translateTraveller(trip.getOrganizer());
        List<TravellerDto> travellers = translateTravellers(trip.getTravellers());

        TripDto tripDto = new TripDto();
        tripDto.setId(id);
        tripDto.setName(name);
        tripDto.setDescription(description);
        tripDto.setLocation(location);
        tripDto.setOrganizer(organizer);
        tripDto.setTravellers(travellers);

        return tripDto;
    }

    @Override
    public Trip translateTrip(TripDto tripDto) {
        Long id = tripDto.getId();
        String name = tripDto.getName();
        String description = tripDto.getDescription();
        Location location = translateLocation(tripDto.getLocation());
        Traveller organizer = translateTraveller(tripDto.getOrganizer());
        Set<Traveller> travellers = translateTravellers(tripDto.getTravellers());

        Trip trip = new Trip();
        trip.setId(id);
        trip.setName(name);
        trip.setDescription(description);
        trip.setLocation(location);
        trip.setOrganizer(organizer);
        trip.setTravellers(travellers);
        return trip;
    }

}

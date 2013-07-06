package org.jiji.trapp.service.translate.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.domain.Trip;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.stereotype.Component;

/**
 * @author J van der Griendt
 * 
 */
@Component
public class TripTranslator implements Translator<TripDto, Trip>
{

    @Inject
    private LocationTranslator locationTranslator;

    @Inject
    private TravellerTranslator travellerTranslator;

    @Override
    public TripDto translate(Trip trip) {
        Long id = trip.getId();
        String name = trip.getName();
        String description = trip.getDescription();
        LocationDto location = locationTranslator.translate(trip.getLocation());
        TravellerDto organizer = travellerTranslator.translate(trip.getOrganizer());
        List<TravellerDto> travellers = travellerTranslator.translateTravellers(trip.getTravellers());

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
    public Trip translate(TripDto tripDto) {
        Long id = tripDto.getId();
        String name = tripDto.getName();
        String description = tripDto.getDescription();
        Location location = locationTranslator.translate(tripDto.getLocation());
        Traveller organizer = travellerTranslator.translate(tripDto.getOrganizer());
        Set<Traveller> travellers = travellerTranslator.translateTravellers(tripDto.getTravellers());

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

package org.jiji.trapp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Set;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.jiji.trapp.util.JsonTranslator;
import org.jiji.trapp.dao.TripDao;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.domain.Trip;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.service.LocationService;
import org.jiji.trapp.service.TravellerService;
import org.jiji.trapp.service.TripService;
import org.jiji.trapp.service.translate.impl.TripTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 *
 */
@Service
public class TripServiceImpl extends AbstractDomainControllerService<TripDto, Trip> implements TripService, Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private LocationService locationService;

    @Inject
    private TravellerService travellerService;

    @Autowired
    public void setTripDao(TripDao tripDao) {
        setRepository(tripDao);
    }

    @Autowired
    public void setTripTranslator(TripTranslator tripTranslator) {
        setTranslator(tripTranslator);
    }

    @Override
    public Class<TripDto> getDtoClass() {
        return TripDto.class;
    }

    @Override
    public Class<Trip> getDomainClass() {
        return Trip.class;
    }

    @Override
    public String addNew(InputStream inputStream) throws IOException {
        String jsonBody = IOUtils.toString(inputStream, "UTF-8");
        TripDto tripDto = (TripDto) JsonTranslator.jsonToObject(jsonBody, TripDto.class);
        Trip trip = getTranslator().translate(tripDto);
        Traveller organizer = travellerService.getActualTraveller(trip.getOrganizer());
        trip.setOrganizer(organizer);
        Set<Traveller> travellers = travellerService.getActualTravellersList(trip.getTravellers());
        trip.setTravellers(travellers);
        Location location = locationService.getActualLocation(trip.getLocation());
        trip.setLocation(location);
        return addNew(trip, jsonBody);
    }
}

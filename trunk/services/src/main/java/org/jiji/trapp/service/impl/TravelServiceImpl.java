package org.jiji.trapp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Set;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.jiji.trapp.JsonTranslator;
import org.jiji.trapp.dao.TravelDao;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.Travel;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.service.LocationService;
import org.jiji.trapp.service.TravelService;
import org.jiji.trapp.service.TravellerService;
import org.jiji.trapp.service.translate.impl.TravelTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 *
 */
@Service
public class TravelServiceImpl extends AbstractDomainControllerService<TravelDto, Travel> implements TravelService, Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private TravellerService travellerService;

    @Inject
    private LocationService locationService;

    @Autowired
    public void setTravelDao(TravelDao travelDao) {
        setRepository(travelDao);
    }

    @Autowired
    public void setTravelTranslator(TravelTranslator travelTranslator) {
        setTranslator(travelTranslator);
    }

    @Override
    public Class<TravelDto> getDtoClass() {
        return TravelDto.class;
    }

    @Override
    public Class<Travel> getDomainClass() {
        return Travel.class;
    }

    @Override
    public String addNew(InputStream inputStream) throws IOException {
        String jsonBody = IOUtils.toString(inputStream, "UTF-8");
        TravelDto travelDto = (TravelDto) JsonTranslator.jsonToObject(jsonBody, TravelDto.class);
        Travel travel = getTranslator().translate(travelDto);
        Traveller organizer = travellerService.getActualTraveller(travel.getOrganizer());
        travel.setOrganizer(organizer);
        Set<Traveller> travellers = travellerService.getActualTravellersList(travel.getTravellers());
        travel.setTravellers(travellers);
        Location location = locationService.getActualLocation(travel.getLocation());
        travel.setLocation(location);
        return addNew(travel, jsonBody);
    }

}

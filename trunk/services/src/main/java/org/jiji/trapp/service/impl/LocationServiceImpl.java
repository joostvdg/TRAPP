package org.jiji.trapp.service.impl;

import java.io.Serializable;
import org.jiji.trapp.dao.LocationDao;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.enums.LocationType;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.service.LocationService;
import org.jiji.trapp.service.translate.impl.LocationTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class LocationServiceImpl extends AbstractDomainControllerService<LocationDto, Location> implements LocationService, Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    public void setLocationDao(LocationDao locationDao) {
        setRepository(locationDao);
    }

    @Autowired
    public void setLocationTranslator(LocationTranslator locationTranslator) {
        setTranslator(locationTranslator);
    }

    @Override
    public String[] getAllLocationTypes() {
        String[] locationTypes = new String[LocationType.values().length];

        for (int i = 0; i < LocationType.values().length; i++) {
            locationTypes[i] = LocationType.values()[i].toString();
        }

        return locationTypes;
    }

    @Override
    public Location getActualLocation(Location translatedLocation) {
        Long locationId = null;

        if (translatedLocation != null) {
            locationId = translatedLocation.getId();
        }

        return getById(locationId);
    }

}

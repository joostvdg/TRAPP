package org.jiji.trapp.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jiji.trapp.dao.LocationDao;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.service.DomainDtoTranslationService;
import org.jiji.trapp.service.LocationService;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class LocationServiceImpl implements LocationService, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private LocationDao locationDao;

    @Inject
    private DomainDtoTranslationService domainDtoTranslationService;

    @Override
    public List<LocationDto> getAllLocationsForExport() {
        List<LocationDto> locationDtos = new ArrayList<>();

        List<Location> locations = locationDao.findAll();
        for (Location location : locations) {
            LocationDto locationDto = domainDtoTranslationService.translateLocation(location);
            locationDtos.add(locationDto);
        }

        return locationDtos;
    }

    @Override
    public void addNewLocation(LocationDto locationDto) {
        Location location = domainDtoTranslationService.translateLocation(locationDto);
        locationDao.saveAndFlush(location);
    }

}

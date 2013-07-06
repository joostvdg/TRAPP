package org.jiji.trapp.service.translate.impl;

import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.enums.LocationType;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.stereotype.Component;

/**
 * @author J van der Griendt
 * 
 */
@Component
public class LocationTranslator implements Translator<LocationDto, Location>
{

    @Override
    public LocationDto translate(Location location) {
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
    public Location translate(LocationDto locationDto) {
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

}

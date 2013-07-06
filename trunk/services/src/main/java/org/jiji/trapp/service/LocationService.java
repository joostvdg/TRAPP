package org.jiji.trapp.service;

import java.util.List;
import org.jiji.trapp.dto.LocationDto;

/**
 * @author J van der Griendt
 * 
 */
public interface LocationService
{

    List<LocationDto> getAllLocationsForExport();

    void addNewLocation(LocationDto locationDto);

}

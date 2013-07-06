package org.jiji.trapp.web.controller;

import java.util.List;
import javax.inject.Inject;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author J van der Griendt
 * 
 */
@Controller
@RequestMapping("/location")
public class LocationController
{

    @Inject
    private LocationService locationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<LocationDto> showLocations() {
        return locationService.getAllForExport();
    }

    @RequestMapping(value = "/{locationId}", method = RequestMethod.GET)
    @ResponseBody
    public LocationDto getTravel(@PathVariable Long locationId) {
        return locationService.getById(locationId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody
    LocationDto addNewLocation(@RequestBody LocationDto locationDto) {
        locationService.addNew(locationDto);
        return locationDto;
    }

}

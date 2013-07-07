package org.jiji.trapp.web.controller;

import javax.inject.Inject;
import org.jiji.trapp.service.LocationService;
import org.jiji.trapp.service.TravellerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValueController
{
    @Inject
    private TravellerService travellerService;

    @Inject
    private LocationService locationService;

    @RequestMapping(value = "/travellerRole", method = RequestMethod.GET)
    @ResponseBody
    public String[] getTravellerRoles() {
        return travellerService.getAllTravellerRoles();
    }

    @RequestMapping(value = "/locationType", method = RequestMethod.GET)
    @ResponseBody
    public String[] getLocationTypes() {
        return locationService.getAllLocationTypes();
    }
}

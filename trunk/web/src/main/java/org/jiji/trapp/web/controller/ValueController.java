package org.jiji.trapp.web.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jiji.trapp.service.LocationService;
import org.jiji.trapp.service.TravellerService;
import org.springframework.stereotype.Controller;

@Controller()
@Path(value = "")
public class ValueController
{
    @Inject
    private TravellerService travellerService;

    @Inject
    private LocationService locationService;

    @Path("/travellerRole")
    @GET
    @Produces("application/json")
    public String[] getTravellerRoles() {
        return travellerService.getAllTravellerRoles();
    }

    @Path("/locationType")
    @GET
    @Produces("application/json")
    public String[] getLocationTypes() {
        return locationService.getAllLocationTypes();
    }
}

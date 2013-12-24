package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author J van der Griendt
 * 
 */
@Controller
@Path("/location")
public class LocationController
{

    @Inject
    private LocationService locationService;

    @GET
    @Produces("application/json")
    public List<LocationDto> showLocations() {
        return locationService.getAllForExport();
    }

    @Path("/{locationId}")
    @GET
    @Produces("application/json")
    public LocationDto getLocation(@PathVariable Long locationId) throws IOException {
        return locationService.getExportById(locationId);
    }

    @POST
    public String addNewLocation(HttpServletRequest request) throws IOException {
        return locationService.addNew(request.getInputStream());
    }

}

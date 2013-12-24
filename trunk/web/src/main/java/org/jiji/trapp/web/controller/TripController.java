package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author J van der Griendt
 * 
 */
@Controller
@Path("/trip")
public class TripController
{

    @Inject
    private TripService tripService;

    @GET
    @Produces("application/json")
    public List<TripDto> getTrips() {
        return tripService.getAllForExport();
    }

    @Path("/{tripId}")
    @GET
    @Produces("application/json")
    public TripDto getTrip(@PathVariable Long tripId) throws IOException {
        return tripService.getExportById(tripId);
    }

    @POST
    public @ResponseBody
    String addNewTrip(HttpServletRequest request) throws IOException {
        return tripService.addNew(request.getInputStream());
    }

}

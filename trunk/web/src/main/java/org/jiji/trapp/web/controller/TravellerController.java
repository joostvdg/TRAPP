package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.service.TravellerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author J van der Griendt
 * 
 */
@Controller
@Path("/traveller")
public class TravellerController
{
    @Inject
    private TravellerService travellerService;

    @GET
    @Produces("application/json")
    public List<TravellerDto> getTravellers() {
        return travellerService.getAllForExport();
    }

    @Path("/{travellerId}")
    @GET
    @Produces("application/json")
    public TravellerDto getTraveller(@PathVariable Long travellerId) throws IOException {
        return travellerService.getExportById(travellerId);
    }

    @POST
    @Produces("application/json")
    public String addNewTraveller(HttpServletRequest request) throws IOException {
        return travellerService.addNew(request.getInputStream());
    }
}

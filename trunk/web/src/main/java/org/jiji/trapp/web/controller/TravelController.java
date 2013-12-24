package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author J van der Griendt
 * 
 */
@Controller
@Path("/travel")
public class TravelController
{

    @Inject
    private TravelService travelService;

    @GET
    @Produces("application/json")
    public List<TravelDto> getTravel() {
        return travelService.getAllForExport();
    }

    @Path("/{travelId}")
    @GET
    @Produces("application/json")
    public TravelDto getTravel(@PathVariable Long travelId) throws IOException {
        return travelService.getExportById(travelId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Produces("application/json")
    public String addNewTravel(HttpServletRequest request) throws IOException {
        return travelService.addNew(request.getInputStream());
    }

}

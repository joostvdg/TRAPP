package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author J van der Griendt
 * 
 */
@Controller
@RequestMapping("/trip")
public class TripController
{

    @Inject
    private TripService tripService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TripDto> getTrips() {
        return tripService.getAllForExport();
    }

    @RequestMapping(value = "/{tripId}", method = RequestMethod.GET)
    @ResponseBody
    public TripDto getTrip(@PathVariable Long tripId) throws IOException {
        return tripService.getExportById(tripId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String addNewTrip(HttpServletRequest request) throws IOException {
        return tripService.addNew(request.getInputStream());
    }

}

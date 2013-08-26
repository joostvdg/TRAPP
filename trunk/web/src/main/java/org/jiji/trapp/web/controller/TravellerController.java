package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.service.TravellerService;
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
@RequestMapping("/traveller")
public class TravellerController
{
    @Inject
    private TravellerService travellerService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TravellerDto> getTravellers() {
        return travellerService.getAllForExport();
    }

    @RequestMapping(value = "/{travellerId}", method = RequestMethod.GET)
    @ResponseBody
    public TravellerDto getTraveller(@PathVariable Long travellerId) throws IOException {
        return travellerService.getExportById(travellerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String addNewTraveller(HttpServletRequest request) throws IOException {
        return travellerService.addNew(request.getInputStream());
    }
}

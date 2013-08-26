package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.service.TravelService;
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
@RequestMapping("/travel")
public class TravelController
{

    @Inject
    private TravelService travelService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TravelDto> getTravel() {
        return travelService.getAllForExport();
    }

    @RequestMapping(value = "/{travelId}", method = RequestMethod.GET)
    @ResponseBody
    public TravelDto getTravel(@PathVariable Long travelId) throws IOException  {
        return travelService.getExportById(travelId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String addNewTravel(HttpServletRequest request) throws IOException {
        return travelService.addNew(request.getInputStream());
    }

}

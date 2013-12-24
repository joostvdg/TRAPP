package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jiji.trapp.dto.UserRoleDto;
import org.jiji.trapp.service.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author J van der Griendt
 * 
 */
@Controller()
@Path("/userRole")
public class UserRoleController
{
    @Inject
    private UserRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    @Produces("application/json")
    public List<UserRoleDto> getUserRoles() {
        return userRoleService.getAllForExport();
    }

    @Path("/{userRoleId}")
    @Produces("application/json")
    public UserRoleDto getUserRole(@PathVariable Long userRoleId) throws IOException {
        return userRoleService.getExportById(userRoleId);
    }

    @POST
    @Produces("application/json")
    public String addNewUserRole(HttpServletRequest request) throws IOException {
        return userRoleService.addNew(request.getInputStream());
    }

}

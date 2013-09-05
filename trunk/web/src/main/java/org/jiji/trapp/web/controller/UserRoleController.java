package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.jiji.trapp.dto.UserRoleDto;
import org.jiji.trapp.service.UserRoleService;
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
@RequestMapping("/userRole")
public class UserRoleController
{
    @Inject
    private UserRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<UserRoleDto> getUserRoles() {
        return userRoleService.getAllForExport();
    }

    @RequestMapping(value = "/{userRoleId}", method = RequestMethod.GET)
    @ResponseBody
    public UserRoleDto getUserRole(@PathVariable Long userRoleId) throws IOException {
        return userRoleService.getExportById(userRoleId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewUserRole(HttpServletRequest request) throws IOException {
        return userRoleService.addNew(request.getInputStream());
    }

}

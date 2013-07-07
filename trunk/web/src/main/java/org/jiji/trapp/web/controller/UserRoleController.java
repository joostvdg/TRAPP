package org.jiji.trapp.web.controller;

import java.util.List;
import javax.inject.Inject;
import org.jiji.trapp.dto.UserRoleDto;
import org.jiji.trapp.service.UserRoleService;
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
@RequestMapping("/userRole")
public class UserRoleController
{
    @Inject
    private UserRoleService userRoleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<UserRoleDto> getUserRoles() {
        return userRoleService.getAllForExport();
    }

    @RequestMapping(value = "/{userRoleId}", method = RequestMethod.GET)
    @ResponseBody
    public UserRoleDto getUserRole(@PathVariable Long userRoleId) {
        return userRoleService.getById(userRoleId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void addNewUserRole(@RequestBody UserRoleDto userRoleDto) {
        userRoleService.addNew(userRoleDto);
    }

}

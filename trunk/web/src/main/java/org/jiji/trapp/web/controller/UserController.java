package org.jiji.trapp.web.controller;

import java.util.List;
import javax.inject.Inject;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.UserService;
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
@RequestMapping("/user")
public class UserController
{
    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getUsers() {
        return userService.getAllForExport();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUser(@PathVariable Long userId) {
        return userService.getExportById(userId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    UserDto addNewUser(@RequestBody UserDto userDto) {
        userService.addNew(userDto);
        return userDto;
    }

}

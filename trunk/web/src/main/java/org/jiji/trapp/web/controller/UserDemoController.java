package org.jiji.trapp.web.controller;

import java.util.List;
import javax.inject.Inject;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserDemoController
{

    @Inject
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<UserDto> showUsers() {
        return userService.getAllUsersForExport();
    }

}

package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.jiji.trapp.JsonTranslator;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.RedisService;
import org.jiji.trapp.service.UserService;
import org.jiji.trapp.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @Inject
    private RedisService redisService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getUsers() {
        return userService.getAllForExport();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUser(@PathVariable Long userId) throws IOException {
        return userService.getExportById(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewUser(HttpServletRequest request) throws IOException {
        return userService.addNew(request.getInputStream());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long userId, HttpServletRequest request) throws IOException {
        String jsonBody = IOUtils.toString(request.getInputStream(), "UTF-8");
        UserDto userDto = (UserDto) JsonTranslator.jsonToObject(jsonBody, UserDto.class);
        String key = RedisUtil.generateKeyForClass(User.class, userDto.getId());
        redisService.set(key, jsonBody);
    }
}

package org.jiji.trapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.apache.commons.io.IOUtils;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.RedisService;
import org.jiji.trapp.service.UserService;
import org.jiji.trapp.util.JsonTranslator;
import org.jiji.trapp.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author J van der Griendt
 * 
 */
@Controller()
@Path("/user")
public class UserController
{
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @Inject
    private RedisService redisService;

    @GET
    @Produces("application/json")
    public List<UserDto> getUsers() {
        return userService.getAllForExport();
    }

    @GET
    @Path("/{userId}")
    @Produces("application/json")
    public UserDto getUser(@PathVariable Long userId) throws IOException {
        return userService.getExportById(userId);
    }

    @POST
    @Produces("application/json")
    public String addNewUser(HttpServletRequest request) throws IOException {
        return userService.addNew(request.getInputStream());
    }

    @PUT
    @Path("/{userId}")
    public void updateUser(@PathVariable Long userId, HttpServletRequest request) throws IOException {
        String jsonBody = IOUtils.toString(request.getInputStream(), "UTF-8");
        LOG.debug(String.format("Update User: %s ", jsonBody));
        UserDto userDto = (UserDto) JsonTranslator.jsonToObject(jsonBody, UserDto.class);
        String key = RedisUtil.generateKeyForClass(User.class, userDto.getId());
        redisService.set(key, jsonBody);
    }
}

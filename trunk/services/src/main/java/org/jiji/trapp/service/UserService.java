package org.jiji.trapp.service;

import java.util.List;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;

/**
 * @author J van der Griendt
 * 
 */
public interface UserService
{

    List<User> getAll();

    List<UserDto> getAllUsersForExport();

    void addNewUser(UserDto userDto);

    UserDto getUserById(Long userId);
}

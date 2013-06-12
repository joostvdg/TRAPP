package org.jiji.trapp.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.DomainDtoTranslationService;
import org.jiji.trapp.service.UserService;

public class UserServiceImpl implements UserService, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    private DomainDtoTranslationService domainDtoTranslationService;

    @Override
    public List<UserDto> getAllUsersForExport() {
        List<User> users = getAll();
        List<UserDto> userDtos = new ArrayList<UserDto>();

        
        for (User user : users){
            UserDto userDto = domainDtoTranslationService.translateUser(user);
            userDtos.add(userDto);
        }

        return userDtos;
    }

    @Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

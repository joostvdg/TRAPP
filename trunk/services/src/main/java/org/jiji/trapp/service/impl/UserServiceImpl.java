package org.jiji.trapp.service.impl;

import java.io.Serializable;
import org.jiji.trapp.dao.UserDao;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.UserService;
import org.jiji.trapp.service.translate.impl.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class UserServiceImpl extends AbstractDomainControllerService<UserDto, User> implements UserService, Serializable
{

    private static final long serialVersionUID = 1L;

    @Autowired
    public void setUserDao(UserDao userDao) {
        setRepository(userDao);
    }

    @Autowired
    public void setUserTranslator(UserTranslator userTranslator) {
        setTranslator(userTranslator);
    }

}

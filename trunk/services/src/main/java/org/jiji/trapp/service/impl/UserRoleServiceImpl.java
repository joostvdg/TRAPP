package org.jiji.trapp.service.impl;

import java.io.Serializable;
import org.jiji.trapp.dao.UserRoleDao;
import org.jiji.trapp.domain.UserRole;
import org.jiji.trapp.dto.UserRoleDto;
import org.jiji.trapp.service.UserRoleService;
import org.jiji.trapp.service.translate.impl.UserRoleTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class UserRoleServiceImpl extends AbstractDomainControllerService<UserRoleDto, UserRole> implements UserRoleService, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        setRepository(userRoleDao);
    }

    @Autowired
    public void setUserRoleTranslator(UserRoleTranslator userRoleTranslator) {
        setTranslator(userRoleTranslator);
    }

}

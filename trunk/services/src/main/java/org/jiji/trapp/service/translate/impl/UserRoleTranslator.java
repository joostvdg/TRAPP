package org.jiji.trapp.service.translate.impl;

import org.jiji.trapp.domain.UserRole;
import org.jiji.trapp.dto.UserRoleDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.stereotype.Component;

/**
 * @author J van der Griendt
 * 
 */
@Component
public class UserRoleTranslator implements Translator<UserRoleDto, UserRole>
{

    @Override
    public UserRoleDto translate(UserRole userRole) {
        Long id = userRole.getId();
        String code = userRole.getCode();
        String description = userRole.getDescription();

        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setId(id);
        userRoleDto.setCode(code);
        userRoleDto.setDescription(description);

        return userRoleDto;
    }

    @Override
    public UserRole translate(UserRoleDto userRoleDto) {
        Long id = userRoleDto.getId();
        String code = userRoleDto.getCode();
        String description = userRoleDto.getDescription();

        UserRole userRole = new UserRole();
        userRole.setId(id);
        userRole.setCode(code);
        userRole.setDescription(description);

        return userRole;
    }

}

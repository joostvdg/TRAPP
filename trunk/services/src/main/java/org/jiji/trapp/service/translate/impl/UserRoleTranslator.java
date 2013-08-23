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
public class UserRoleTranslator extends AbstractTranslator<UserRoleDto, UserRole> implements Translator<UserRoleDto, UserRole>
{

    @Override
    public UserRoleDto translate(UserRole userRole) {
        String code = userRole.getCode();
        String description = userRole.getDescription();

        UserRoleDto userRoleDto = new UserRoleDto();
        translateBaseFromDomainToDto(userRole, userRoleDto);
        userRoleDto.setCode(code);
        userRoleDto.setDescription(description);

        return userRoleDto;
    }

    @Override
    public UserRole translate(UserRoleDto userRoleDto) {
        String code = userRoleDto.getCode();
        String description = userRoleDto.getDescription();

        UserRole userRole = new UserRole();
        translateBaseFromDtoToDomain(userRoleDto, userRole);
        userRole.setCode(code);
        userRole.setDescription(description);

        return userRole;
    }

}

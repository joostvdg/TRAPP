package org.jiji.trapp.service.translate.impl;

import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.stereotype.Component;

/**
 * @author J van der Griendt
 *
 */
@Component
public class UserTranslator extends AbstractTranslator<UserDto, User> implements Translator<UserDto, User>
{

    @Override
    public UserDto translate(User user) {
        String name = user.getName();
        String surnamePrefix = user.getSurnamePrefix();
        String surname = user.getSurname();
        String email = user.getEmail();

        UserDto userDto = new UserDto();
        translateBaseFromDomainToDto(user, userDto);
        userDto.setName(name);
        userDto.setSurnamePrefix(surnamePrefix);
        userDto.setSurname(surname);
        userDto.setEmail(email);

        return userDto;
    }

    @Override
    public User translate(UserDto userDto) {
        String name = userDto.getName();
        String surnamePrefix = userDto.getSurnamePrefix();
        String surname = userDto.getSurname();
        String email = userDto.getEmail();

        User user = new User();
        translateBaseFromDtoToDomain(userDto, user);
        user.setName(name);
        user.setSurnamePrefix(surnamePrefix);
        user.setSurname(surname);
        user.setEmail(email);
        return user;
    }

}

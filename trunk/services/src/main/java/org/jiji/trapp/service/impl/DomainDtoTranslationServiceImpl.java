package org.jiji.trapp.service.impl;

import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.DomainDtoTranslationService;



public class DomainDtoTranslationServiceImpl implements DomainDtoTranslationService {

    @Override
    public UserDto translateUser(User user) {
        Long id = user.getId();
        String name = user.getName();
        String preposition = user.getPreposition();
        String surname = user.getSurname();
        String email = user.getEmail();

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setPreposition(preposition);
        userDto.setSurname(surname);
        userDto.setEmail(email);

        return userDto;
    }

}

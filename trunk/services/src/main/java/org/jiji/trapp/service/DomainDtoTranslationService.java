package org.jiji.trapp.service;

import org.jiji.trapp.domain.User;
import org.jiji.trapp.dto.UserDto;


public interface DomainDtoTranslationService {
	UserDto translateUser(User user) ;
}

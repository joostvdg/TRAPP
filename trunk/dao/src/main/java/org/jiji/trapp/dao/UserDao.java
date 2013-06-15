package org.jiji.trapp.dao;

import org.jiji.trapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>
{

}

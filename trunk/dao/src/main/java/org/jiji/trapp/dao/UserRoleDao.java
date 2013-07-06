package org.jiji.trapp.dao;

import org.jiji.trapp.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author J van der Griendt
 * 
 */
public interface UserRoleDao extends JpaRepository<UserRole, Long>
{

}

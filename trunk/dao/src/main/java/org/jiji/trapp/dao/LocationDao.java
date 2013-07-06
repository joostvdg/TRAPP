package org.jiji.trapp.dao;

import org.jiji.trapp.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author J van der Griendt
 * 
 */
public interface LocationDao extends JpaRepository<Location, Long>
{

}

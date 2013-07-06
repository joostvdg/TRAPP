package org.jiji.trapp.dao;

import org.jiji.trapp.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author J van der Griendt
 * 
 */
public interface TravelDao extends JpaRepository<Travel, Long>
{

}

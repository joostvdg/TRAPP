package org.jiji.trapp.dao;

import org.jiji.trapp.domain.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author J van der Griendt
 * 
 */
public interface TravellerDao extends JpaRepository<Traveller, Long>
{

}

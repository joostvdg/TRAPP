package org.jiji.trapp.dao;

import org.jiji.trapp.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author J van der Griendt
 * 
 */
public interface TripDao extends JpaRepository<Trip, Long>
{

}

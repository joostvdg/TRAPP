package org.jiji.trapp.service.impl;

import java.io.Serializable;
import org.jiji.trapp.dao.TripDao;
import org.jiji.trapp.domain.Trip;
import org.jiji.trapp.dto.TripDto;
import org.jiji.trapp.service.TripService;
import org.jiji.trapp.service.translate.impl.TripTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class TripServiceImpl extends AbstractDomainControllerService<TripDto, Trip> implements TripService, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    public void setTripDao(TripDao tripDao) {
        setRepository(tripDao);
    }

    @Autowired
    public void setTripTranslator(TripTranslator tripTranslator) {
        setTranslator(tripTranslator);
    }

}

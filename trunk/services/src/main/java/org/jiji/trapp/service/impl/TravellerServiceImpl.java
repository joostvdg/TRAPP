package org.jiji.trapp.service.impl;

import java.io.Serializable;
import org.jiji.trapp.dao.TravellerDao;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.service.TravellerService;
import org.jiji.trapp.service.translate.impl.TravellerTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class TravellerServiceImpl extends AbstractDomainControllerService<TravellerDto, Traveller> implements TravellerService,
        Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    public void setTravellerDao(TravellerDao travellerDao) {
        setRepository(travellerDao);
    }

    @Autowired
    public void setTravellerTranslator(TravellerTranslator travellerTranslator) {
        setTranslator(travellerTranslator);
    }

}

package org.jiji.trapp.service.impl;

import java.io.Serializable;
import org.jiji.trapp.dao.TravelDao;
import org.jiji.trapp.domain.Travel;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.service.TravelService;
import org.jiji.trapp.service.translate.impl.TravelTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author J van der Griendt
 * 
 */
@Service
public class TravelServiceImpl extends AbstractDomainControllerService<TravelDto, Travel> implements TravelService, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    public void setTravelDao(TravelDao travelDao) {
        setRepository(travelDao);
    }

    @Autowired
    public void setTravelTranslator(TravelTranslator travelTranslator) {
        setTranslator(travelTranslator);
    }

}

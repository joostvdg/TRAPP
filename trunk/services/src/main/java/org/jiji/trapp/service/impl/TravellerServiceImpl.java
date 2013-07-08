package org.jiji.trapp.service.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import org.jiji.trapp.dao.TravellerDao;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.domain.enums.TravellerRole;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.service.TravellerService;
import org.jiji.trapp.service.UserService;
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

    @Inject
    private UserService userService;

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

    @Override
    public String[] getAllTravellerRoles() {
        String[] travellerRoles = new String[TravellerRole.values().length];

        for (int i = 0; i < TravellerRole.values().length; i++) {
            travellerRoles[i] = TravellerRole.values()[i].toString();
        }

        return travellerRoles;
    }

    @Override
    public void addNew(TravellerDto travellerDto) {
        Traveller traveller = getTranslator().translate(travellerDto);
        User translatedUser = traveller.getUser();
        Long userId = null;

        if (translatedUser != null) {
            userId = translatedUser.getId();
        }

        User user = userService.getById(userId);
        traveller.setUser(user);
        getRespository().save(traveller);
    }

    @Override
    public Traveller getActualTraveller(Traveller translatedTraveller) {
        Long organizerId = null;

        if (translatedTraveller != null) {
            organizerId = translatedTraveller.getId();
        }

        return getById(organizerId);
    }

    @Override
    public Set<Traveller> getActualTravellersList(Set<Traveller> translatedTravellers) {
        Set<Traveller> travellers = new HashSet<>();
        for (Traveller translatedTraveller : translatedTravellers) {
            Traveller traveller = getActualTraveller(translatedTraveller);
            if (traveller != null) {
                travellers.add(traveller);
            }
        }
        return travellers;
    }

}

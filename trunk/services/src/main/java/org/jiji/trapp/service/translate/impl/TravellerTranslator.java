package org.jiji.trapp.service.translate.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.domain.User;
import org.jiji.trapp.domain.enums.TravellerRole;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.dto.UserDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.stereotype.Component;

/**
 * @author J van der Griendt
 *
 */
@Component
public class TravellerTranslator extends AbstractTranslator<TravellerDto, Traveller> implements Translator<TravellerDto, Traveller>
{
    @Inject
    private UserTranslator userTranslator;

    @Override
    public TravellerDto translate(Traveller traveller) {
        Long id = traveller.getId();
        String travellerRole = traveller.getTravellerRole().name();
        UserDto user = userTranslator.translate(traveller.getUser());

        TravellerDto travellerDto = new TravellerDto();
        translateBaseFromDomainToDto(traveller, travellerDto);
        travellerDto.setId(id);
        travellerDto.setTravellerRole(travellerRole);
        travellerDto.setUser(user);

        return travellerDto;
    }

    @Override
    public Traveller translate(TravellerDto travellerDto) {
        TravellerRole travellerRole = TravellerRole.valueOf(travellerDto.getTravellerRole());
        User user = userTranslator.translate(travellerDto.getUser());

        Traveller traveller = new Traveller();
        translateBaseFromDtoToDomain(travellerDto, traveller);
        traveller.setTravellerRole(travellerRole);
        traveller.setUser(user);
        return traveller;
    }

    public Set<Traveller> translateTravellers(List<TravellerDto> travellerDtos) {
        Set<Traveller> travellers = new HashSet<>();

        for (TravellerDto travellerDto : travellerDtos) {
            Traveller traveller = translate(travellerDto);
            travellers.add(traveller);
        }

        return travellers;
    }

    public List<TravellerDto> translateTravellers(Set<Traveller> travellers) {
        List<TravellerDto> travellerDtos = new ArrayList<>();

        for (Traveller traveller : travellers) {
            TravellerDto travellerDto = translate(traveller);
            travellerDtos.add(travellerDto);
        }

        return travellerDtos;
    }
}

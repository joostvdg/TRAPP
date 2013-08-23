package org.jiji.trapp.service.translate.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.jiji.trapp.domain.Location;
import org.jiji.trapp.domain.Travel;
import org.jiji.trapp.domain.Traveller;
import org.jiji.trapp.dto.LocationDto;
import org.jiji.trapp.dto.TravelDto;
import org.jiji.trapp.dto.TravellerDto;
import org.jiji.trapp.service.translate.Translator;
import org.springframework.stereotype.Component;

/**
 * @author J van der Griendt
 *
 */
@Component
public class TravelTranslator extends AbstractTranslator<TravelDto, Travel> implements Translator<TravelDto, Travel>
{

    @Inject
    private LocationTranslator locationTranslator;

    @Inject
    private TravellerTranslator travellerTranslator;

    @Override
    public TravelDto translate(Travel travel) {
        String name = travel.getName();
        String description = travel.getDescription();
        LocationDto location = locationTranslator.translate(travel.getLocation());
        TravellerDto organizer = travellerTranslator.translate(travel.getOrganizer());
        List<TravellerDto> travellers = travellerTranslator.translateTravellers(travel.getTravellers());

        TravelDto travelDto = new TravelDto();
        translateBaseFromDomainToDto(travel, travelDto);
        travelDto.setName(name);
        travelDto.setDescription(description);
        travelDto.setLocation(location);
        travelDto.setOrganizer(organizer);
        travelDto.setTravellers(travellers);
        return travelDto;

    }

    @Override
    public Travel translate(TravelDto travelDto) {
        String name = travelDto.getName();
        String description = travelDto.getDescription();
        Location location = locationTranslator.translate(travelDto.getLocation());
        Traveller organizer = travellerTranslator.translate(travelDto.getOrganizer());
        Set<Traveller> travellers = travellerTranslator.translateTravellers(travelDto.getTravellers());

        Travel travel = new Travel();
        translateBaseFromDtoToDomain(travelDto, travel);
        travel.setName(name);
        travel.setDescription(description);
        travel.setLocation(location);
        travel.setOrganizer(organizer);
        travel.setTravellers(travellers);

        return travel;

    }

}

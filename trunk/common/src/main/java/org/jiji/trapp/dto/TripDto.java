package org.jiji.trapp.dto;

import java.util.List;

/**
 * @author J van der Griendt
 * 
 */
public class TripDto extends AbstractJsonDto
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private LocationDto location;
    private TravellerDto organizer;
    private List<TravellerDto> travellers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public TravellerDto getOrganizer() {
        return organizer;
    }

    public void setOrganizer(TravellerDto organizer) {
        this.organizer = organizer;
    }

    public List<TravellerDto> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<TravellerDto> travellers) {
        this.travellers = travellers;
    }

}

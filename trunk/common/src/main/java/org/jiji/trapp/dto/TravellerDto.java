package org.jiji.trapp.dto;


/**
 * @author J van der Griendt
 * 
 */
public class TravellerDto extends AbstractJsonDto
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String travellerRole;
    private UserDto user;

    public String getTravellerRole() {
        return travellerRole;
    }

    public void setTravellerRole(String travellerRole) {
        this.travellerRole = travellerRole;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

}

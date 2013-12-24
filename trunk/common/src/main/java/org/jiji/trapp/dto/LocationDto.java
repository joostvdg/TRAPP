package org.jiji.trapp.dto;


/**
 * @author J van der Griendt
 * 
 */
public class LocationDto extends AbstractJsonDto
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String locationType;

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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

}

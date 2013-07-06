package org.jiji.trapp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import org.jiji.trapp.domain.enums.LocationType;

/**
 * @author J van der Griendt
 * 
 */
@Entity
public class Location extends ModelBase implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column(length = 45, nullable = false, unique = true)
    @NotNull
    private String name;

    @Column(length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

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

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((locationType == null) ? 0 : locationType.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        if (locationType != other.locationType) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, name=%s, description=%s, locationType=%s]", getClass().getSimpleName(), getId(), name, description,
                locationType);
    }
}

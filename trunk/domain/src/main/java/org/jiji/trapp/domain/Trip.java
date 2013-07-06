package org.jiji.trapp.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author J van der Griendt
 * 
 */
@Entity
public class Trip extends ModelBase implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column(length = 45, nullable = false)
    @NotNull
    private String name;

    @Column(length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "locationId")
    @NotNull
    private Location location;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private Traveller organizer;

    @ManyToMany
    private Set<Traveller> travellers;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Traveller getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Traveller organizer) {
        this.organizer = organizer;
    }

    public Set<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(Set<Traveller> travellers) {
        this.travellers = travellers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((organizer == null) ? 0 : organizer.hashCode());
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
        if (!(obj instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (organizer == null) {
            if (other.organizer != null) {
                return false;
            }
        }
        else if (!organizer.equals(other.organizer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, name=%s, organizer=%s, location=%s]", getClass().getSimpleName(), getId(), name, organizer,
                location);
    }

}

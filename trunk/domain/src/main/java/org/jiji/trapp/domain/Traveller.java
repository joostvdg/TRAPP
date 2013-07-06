package org.jiji.trapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.jiji.trapp.domain.enums.TravellerRole;

/**
 * @author J van der Griendt
 * 
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "userId", "travellerRole" }) })
public class Traveller extends ModelBase implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TravellerRole travellerRole;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

    public TravellerRole getTravellerRole() {
        return travellerRole;
    }

    public void setTravellerRole(TravellerRole travellerRole) {
        this.travellerRole = travellerRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((travellerRole == null) ? 0 : travellerRole.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        if (!(obj instanceof Traveller)) {
            return false;
        }
        Traveller other = (Traveller) obj;
        if (travellerRole != other.travellerRole) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        }
        else if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, user=%s, role=%s]", getClass().getSimpleName(), getId(), user, travellerRole);
    }
}

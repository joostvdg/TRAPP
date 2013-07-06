package org.jiji.trapp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author J van der Griendt
 * 
 */
@Entity
public class UserRole extends ModelBase implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Column(length = 25, unique = true, nullable = false)
    private String code;

    @Column(length = 255)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, code=%s, description=%s]", getClass().getSimpleName(), getId(), code, description);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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
        if (!(obj instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        }
        else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }

}

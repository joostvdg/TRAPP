package org.jiji.trapp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author J van der Griendt
 * 
 */
@Entity
public class User extends ModelBase implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Column(length = 55, nullable = false)
    private String name;

    @Column(length = 10, nullable = true)
    private String surnamePrefix;

    @Column(length = 55, nullable = false)
    private String surname;

    @Column(length = 128, nullable = false, unique = true)
    private String email;

    @ManyToMany
    private Set<UserRole> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnamePrefix() {
        return surnamePrefix;
    }

    public void setSurnamePrefix(String surnamePrefix) {
        this.surnamePrefix = surnamePrefix;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRole> getRoles() {
        return new HashSet<UserRole>(roles);
    }

    @SuppressWarnings("unused")
    private void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public boolean addRole(UserRole userRole) {
        return roles.add(userRole);
    }

    public boolean removeRole(UserRole userRole) {
        return roles.remove(userRole);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        }
        else if (!email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, name=%s, surnamePrefix=%s, surname=%s]", getClass().getSimpleName(), getId(), name, surnamePrefix,
                surname);
    }

}

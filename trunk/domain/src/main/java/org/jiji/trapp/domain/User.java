package org.jiji.trapp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.jiji.trapp.domain.listener.Auditor;



/**
 *
 * @author jvdgriendt
 */
@Entity
@EntityListeners(Auditor.class)
public class User extends ModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length=55, nullable=false)
    private String name;

    @Column(length=10, nullable=true)
    private String preposition;

    @Column(length=55, nullable=false)
    private String surname;

    @Column(length=128, nullable=false, unique=true)
    private String email;

    @ManyToMany
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "owner")
    private Set<Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
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

    public boolean addRole(UserRole userRole){
        return roles.add(userRole);
    }

    public boolean removeRole(UserRole userRole){
        return roles.remove(userRole);
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    @SuppressWarnings("unused")
    private void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account){
        return accounts.add(account);
    }

    public boolean removeAccount(Account account){
        return accounts.remove(account);
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
        return String.format("%s[id=%d, name=%s, preposition=%s, surname=%s]", getClass().getSimpleName(),getId(), name, preposition, surname);
    }

}

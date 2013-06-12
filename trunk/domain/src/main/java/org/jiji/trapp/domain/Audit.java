package org.jiji.trapp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jiji.trapp.domain.enums.AuditAction;


/**
 * @author jvdgriendt
 * 
 */
@Entity
public class Audit extends ModelBase implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private AuditAction action;

    @Column(length=255)
    private String user;

    @Column(length=255)
    private String userRole;

    @Column(length=255)
    private String description;


    public AuditAction getAction() {
        return action;
    }

    public void setAction(AuditAction action) {
        this.action = action;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s [ id=%d, action=%s, user=%s, userRole=%s, description=%s]",getClass().getSimpleName(), getId(), action, user,userRole, description);
    }
}

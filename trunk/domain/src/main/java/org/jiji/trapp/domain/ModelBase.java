package org.jiji.trapp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author J van der Griendt
 * @author H Onrust
 * 
 */
@MappedSuperclass
public abstract class ModelBase implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (!(obj instanceof ModelBase))) {
            return false;
        }
        ModelBase other = (ModelBase) obj;
        if ((other.getId() == null) || (getId() == null)) {
            return false;
        }
        return (this == obj) || getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId() == null ? super.hashCode() : getId().intValue();
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d])", getClass().getSimpleName(), getId());
    }

    @Transient
    public boolean isNew() {
        return getId() == null;
    }
}
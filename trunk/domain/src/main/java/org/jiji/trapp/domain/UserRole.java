package org.jiji.trapp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.jiji.trapp.domain.listener.Auditor;



/**
 *
 * @author jvdgriendt
 */
@Entity
@EntityListeners(Auditor.class)
public class UserRole extends ModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length=25, unique=true, nullable=false)
    private String code;

    @Column(length=255, unique=true, nullable=false)
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
}

package org.jiji.trapp.domain.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jvdgriendt
 * 
 */

public class Auditor
{

    private static final Logger LOG = LoggerFactory.getLogger(Auditor.class);

    @PostPersist
    void postPersist(final Object entity) {
        LOG.info(String.format("Persisting of object %s", entity.toString()));
    }

    @PostLoad
    void postLoad(final Object entity) {
        if (entity != null) {
            LOG.info(String.format("Loading of object %s.", entity.toString()));
        }
    }

    @PostUpdate
    void postUpdate(final Object entity) {
        LOG.info(String.format("Updating of object %s.", entity.toString()));
    }

}

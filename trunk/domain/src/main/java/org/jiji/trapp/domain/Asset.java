package org.jiji.trapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import nl.flusso.commons.assetservice.model.AssetBase;

@Entity
@Table(name = "Asset", schema = "trapp")
public class Asset extends AssetBase implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
}

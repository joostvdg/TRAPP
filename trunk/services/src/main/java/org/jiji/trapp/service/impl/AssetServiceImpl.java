package org.jiji.trapp.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.inject.Inject;
import nl.flusso.commons.assetservice.service.AssetServiceBase;
import org.jiji.trapp.dao.AssetDao;
import org.jiji.trapp.domain.Asset;
import org.jiji.trapp.service.AssetService;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl extends AssetServiceBase<Asset> implements AssetService
{

    @Inject
    private AssetDao assetDao;

    @Override
    public Asset create() {
        return new Asset();
    }

    @Override
    public Asset getMostRecent(String table, int recordId, int type, String filename) {
        return null;  // To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Asset getById(Long assetId) {
        return assetDao.findOne(assetId);  // To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String show(Long assetId) {
        try {
            return new String(getById(assetId).getData(), "UTF-8");  // To change body of implemented methods use File |
                                                                    // Settings | File Templates.
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();  // To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public List<Asset> getListOrderedByFileNameDate(String table, Long id, int type) {
        return null;  // To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Asset> getList(String table, Long id, int type, String filename) {
        return null;  // To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Asset> getList(String table, Long id, int type) {
        // TODO: implement per table query
        return assetDao.findAll();
    }

    @Override
    public void persist(Asset asset) {
        assetDao.save(asset);
    }

    @Override
    public void deleteById(Long assetId) {
        // To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieve the default image
     * 
     * @param asset
     *            t
     * @return
     */
    @Override
    public String getDefaultImage(Asset asset) {
        return null;  // To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieve the image used if non is present
     * 
     * @param asset
     *            t
     * @return
     */
    @Override
    public String getNoImage(Asset asset) {
        return null;  // To change body of implemented methods use File | Settings | File Templates.
    }
}

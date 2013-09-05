package org.jiji.trapp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AssetLogger implements nl.flusso.commons.assetservice.logging.Logger
{
    private static final Logger LOG = LoggerFactory.getLogger(AssetLogger.class);

    @Override
    public void debug(String message) {
        LOG.debug(message);
    }

    @Override
    public void error(String message, Throwable e) {
        LOG.error(message, e);
    }

    @Override
    public void info(String message) {
        LOG.info(message);
    }

    @Override
    public void warn(String message) {
        LOG.warn(message);
    }

}

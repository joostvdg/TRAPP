package org.jiji.trapp.service.impl;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import org.jiji.trapp.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * User: Joost van der Griendt
 * Date: 8/16/13
 * Time: 11:59 PM
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger LOG = LoggerFactory.getLogger(RedisServiceImpl.class);

    private RedisConnection<String,String> connection;

    private ApplicationContext applicationContext;

    private boolean available = false;

    RedisServiceImpl(){
        try {
            RedisClient  client = new RedisClient("localhost");
            connection = client.connect();
            available = "PONG".equals(connection.ping());
        } catch (Throwable t) {
            LOG.error("No Redis connection!", t);
        }
    }

    @Override
    public void set(String key, String value) {
        if (available)
            connection.set(key, value);
    }

    @Override
    public String get(String key) {
        if (available)
            return connection.get(key);
        return null;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

}

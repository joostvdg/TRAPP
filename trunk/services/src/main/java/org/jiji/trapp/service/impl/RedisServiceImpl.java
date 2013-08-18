package org.jiji.trapp.service.impl;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import org.jiji.trapp.service.RedisService;
import org.springframework.stereotype.Service;

/**
 * User: Joost van der Griendt
 * Date: 8/16/13
 * Time: 11:59 PM
 */
@Service
public class RedisServiceImpl implements RedisService {

    private RedisConnection<String,String> connection;

    RedisServiceImpl(){
        RedisClient  client = new RedisClient("localhost");
        connection = client.connect();
    }

    @Override
    public void set(String key, String value) {
        connection.set(key, value);
    }

    @Override
    public String get(String key) {
        return connection.get(key);
    }

}

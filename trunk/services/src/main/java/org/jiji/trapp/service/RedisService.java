package org.jiji.trapp.service;

import org.springframework.stereotype.Service;

/**
 * User: Joost van der Griendt
 * Date: 8/16/13
 * Time: 11:57 PM
 */
public interface RedisService {
    void set(String key, String jsonBody);

    String get(String key);
}

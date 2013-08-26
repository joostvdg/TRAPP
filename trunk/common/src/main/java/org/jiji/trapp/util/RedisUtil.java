package org.jiji.trapp.util;

/**
 * User: Joost van der Griendt
 * Date: 8/23/13
 * Time: 7:50 AM
 */
public class RedisUtil {

    public static final String generateKeyForClass(Class<?> clasz, String identifier){
        String className = clasz.getSimpleName();
        return String.format("%s:%s", className, identifier);
    }

    public static final String generateKeyForClass(Class<?> clasz, long id){
        String className = clasz.getSimpleName();
        return String.format("%s:%d", className, id);
    }
}

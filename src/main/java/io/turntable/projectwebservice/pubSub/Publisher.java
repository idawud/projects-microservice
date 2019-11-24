package io.turntable.projectwebservice.pubSub;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.net.URISyntaxException;

public class Publisher extends RedisConnection {
    public static void publish(String message){
        try {
            Jedis jedis = getPool().getResource();
            jedis.publish("projects", "Message: " + message);
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.getMessage();
        }
    }
}

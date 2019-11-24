package io.turntable.projectwebservice.pubSub;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.net.URI;
import java.net.URISyntaxException;

public class Publisher {
    public static void sendMessage(String message){
        Jedis jedis = null;
        try {
            URI redisURI = new URI(System.getenv("REDIS_URL"));
            jedis = new Jedis(redisURI);

//            Jedis jedis = getPool().getResource();
            jedis.publish("projects", "Message: " + message);
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.getMessage();
        }
    }
}

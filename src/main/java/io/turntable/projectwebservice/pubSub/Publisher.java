package io.turntable.projectwebservice.pubSub;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.net.URISyntaxException;

public class Publisher {
    public static void sendMessage(String message) {
//        try (Jedis jedis = getPool().getResource()){
//            jedis.publish("projects", "Message: " + message);
//        } catch (URISyntaxException uriSyntaxException) {
//            uriSyntaxException.getMessage();
//        }

//        redis local connection
        Jedis jedis = new Jedis("localhost");
        // publishing the message
        jedis.publish("projects", "Message: " + message);
    }
}

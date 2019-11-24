//package io.turntable.projectwebservice.log;
//
//import io.turntable.projectwebservice.ProjectWebserviceApplication;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.Jedis;
//
//import java.time.LocalDateTime;
//
//public class Pub {
//
//    public static void sendMessageLog(String message) {
////        try (Jedis jedis = getPool().getResource()){
////            jedis.publish("projects", "Message: " + message);
////        } catch (URISyntaxException uriSyntaxException) {
////            uriSyntaxException.getMessage();
////        }
//
//
////        redis local connection
//        Jedis jedis = new Jedis("localhost");
//        jedis.publish("projects", LocalDateTime.now().toString() + " : " + message);
//    }
//}

//package io.turntable.projectwebservice.pubSub;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPubSub;
//
//import java.net.URISyntaxException;
//
//public class Subscriber extends  RedisConnection {
//
//    public static void onMessage() {
//        try {
//            Jedis jedisSubscriber = getPool().getResource();
//            jedisSubscriber.subscribe(new JedisPubSub() {
//                @Override
//                public void onMessage(String channel, String message) {
////                    super.onMessage(channel, message);
//                }
//            }, "project");
//        } catch (URISyntaxException uriEx) {
//            uriEx.printStackTrace();
//        }
//    }
//}
//
// no subscription yet

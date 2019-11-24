//package io.turntable.projectwebservice.pubSub;
//
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//public class RedisConnection {
//
//    static JedisPool getPool() throws URISyntaxException {
//        URI redisURI = new URI(System.getenv("REDIS_URI"));
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(10);
//        poolConfig.setMaxIdle(5);
//        poolConfig.setMinIdle(1);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(true);
//        poolConfig.setTestWhileIdle(true);
//        JedisPool jedisPool = new JedisPool(poolConfig, redisURI);
//        return jedisPool;
//    }
//}
//
//
//
//// not needed for local redis connection
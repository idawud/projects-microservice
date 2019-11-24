//package io.turntable.projectwebservice.log;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//public class RedisCon {
//    @Bean
//    public RedisConnectionFactory jedisConnectionFactory(){
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(10);
//        poolConfig.setMaxIdle(5);
//        poolConfig.setMinIdle(1);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(true);
//        poolConfig.setTestWhileIdle(true);
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
//        return jedisConnectionFactory;
//    }
//}

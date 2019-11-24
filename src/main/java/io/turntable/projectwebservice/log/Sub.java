package io.turntable.projectwebservice.log;

import io.turntable.projectwebservice.ProjectWebserviceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
/*
 * log only listing to message
 * */

public class Sub {
    // logging the entire activity of the app
    public static final Logger logger = LoggerFactory
            .getLogger(ProjectWebserviceApplication.class);

    public static void receiveMessage() {
        Jedis jedisSubscriber = new Jedis("localhost");
        // logging anytime listens
        jedisSubscriber.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                logger.warn("***logger test*********." + message + "***********");
                // logging depending on the channel
                if (channel.equals("projects")) {
                    projectsTopic(channel, message);
                } else if (channel.equals("customers")) {
                    customersTopic(channel, message);
                } else {
                    logger.warn("Invalid topic: " + channel);
                }
            }
        }, "projects", "customers"); // listens & log from this channels

    }

    private static void projectsTopic(String channel, String message) {
//        logging messages with channels
        if (message.trim().endsWith("[UPDATE]") || message.trim().endsWith("[ACCESS]")) {
            logger.info(channel + " : " + message);
        } else if (message.trim().endsWith("[ERROR]")) {
            logger.warn(channel + " : " + message);
        } else {
            logger.warn(message);
        }
    }

    // tho no customer service....can test with redis-cli with channel `customers`
    private static void customersTopic(String channel, String message) {
//        logging ....
        logger.warn("^^^^^^^^^^" + channel + " ::: "+ message + "^^^^^^^^^^^^");
        logger.info(channel + " : " + message);
    }


}

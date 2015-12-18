package io.pivotal.fe.demo.ui;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

@Configuration
@Profile("cloud")
public class RedisCloudConfig extends AbstractCloudConfig {

    @Bean
    public RedisConnectionFactory redisConnection() {
        return connectionFactory().redisConnectionFactory();
    }
    
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

}

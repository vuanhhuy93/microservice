package com.huyva.customer.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.io.File;
import java.io.IOException;

@EnableRedisRepositories
@Configuration
public class RedisConfig {

    @Autowired
    Environment env;

    private static final String SINGLE = "single";

    @Bean
    public RedissonClient createRedissionClient() throws IOException {
         String fileUrl = env.getProperty("redis.config-file");

        Config config = Config.fromYAML(new File(fileUrl));
         return Redisson.create(config);
    }

    @Bean
    RedisTemplate<String, Object> redisTemplate(@Autowired RedissonConnectionFactory redissonConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redissonConnectionFactory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return template;
    }

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(@Autowired RedissonClient redissonClient ) {
        return new RedissonConnectionFactory(redissonClient);
    }
}

//package ru.aston.trainee.team3_library.configs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
//public class RedisConfig {
//    @Bean
//    public RedisTemplate<Long, Book> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<Long, Book> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        // Add some specific configuration here. Key serializers, etc.
//        return template;
//    }
//}

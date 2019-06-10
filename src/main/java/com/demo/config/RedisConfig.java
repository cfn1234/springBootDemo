package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.config
 *
 * @author caofengnian 2019/4/15 0015 09:30
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Serializable> limitRedisTemplate(LettuceConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}

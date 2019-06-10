package com.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.interceptor
 *
 * @author caofengnian
 * @Date 2019/6/10 0010 09:28
 */
@Component
public class SimpleRateLimiter implements HandlerInterceptor {

	private final RedisTemplate<String, String> limitRedisTemplate;

	@Autowired
	public SimpleRateLimiter(RedisTemplate<String, String> limitRedisTemplate) {
		this.limitRedisTemplate = limitRedisTemplate;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		isActionAllow("11", "11", 10, 3);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	public boolean isActionAllow(String userId, String actionKey, int period, int maxCount) throws IOException {
		String key = String.format("hist6:%s:%s", userId, actionKey);
		long nowTs = System.currentTimeMillis();
		List<Object> List = limitRedisTemplate.executePipelined(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				connection.zAdd(key.getBytes(), nowTs, (nowTs + "").getBytes());
				connection.zRemRangeByScore(key.getBytes(), 0, nowTs - period * 1000);
				connection.zCard(key.getBytes());
				connection.expire(key.getBytes(), period);
				return null;
			}
		});
		boolean a = (Long) List.get(2) <= maxCount;
		System.out.println(a);
		return false;
	}
}

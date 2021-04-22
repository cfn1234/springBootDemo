package com.demo.config;

import com.demo.interceptor.SimpleRateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <br>
 * mvc配置
 * com.demo.config
 *
 * @author caofengnian
 * @Date 2019/6/10 0010 09:48
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
    
    @Autowired
    private SimpleRateLimiter myInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/hello/**");
        super.addInterceptors(registry);
    }
    
}

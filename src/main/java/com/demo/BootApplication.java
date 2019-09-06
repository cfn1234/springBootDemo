package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo
 *
 * @author caofengnian 2019/4/11 0011 14:13
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SpringBootApplication
public class BootApplication extends SpringBootServletInitializer {

	// 外部容器启动类
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(BootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}

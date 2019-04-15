package com.demo.controller;

import com.demo.config.Handler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo
 *
 * @author caofengnian 2019/4/11 0011 15:10
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloController {

	@Handler
	private String  testSerivce;
	@Handler
	private String  testSerivces;
	@Handler
	private String  testSerivce2;
}

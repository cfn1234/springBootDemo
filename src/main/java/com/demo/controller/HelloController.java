package com.demo.controller;

import com.demo.LimitType.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo
 *
 * @author caofengnian 2019/4/11 0011 15:10
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("/hello")
@RestController
public class HelloController {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
    
    @Limit(key = "test", period = 1000, count = 1, name = "resource", prefix = "limit")
    @GetMapping("/test")
    public String testLimiter() {
        // 意味着100S内最多可以访问10次
        return "11111";
    }
}

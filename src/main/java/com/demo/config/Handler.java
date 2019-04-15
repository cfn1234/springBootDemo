package com.demo.config;

import java.lang.annotation.*;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.config
 *
 * @author caofengnian 2019/4/11 0011 14:38
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Handler {
	String[] value() default "";
}
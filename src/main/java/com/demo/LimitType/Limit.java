package com.demo.LimitType;

import java.lang.annotation.*;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.LimitType
 *
 * @author caofengnian 2019/4/15 0015 09:30
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface  Limit {
	/**
	 * 资源的名字
	 *
	 * @return String
	 */
	String name() default "";

	/**
	 * 资源的key
	 *
	 * @return String
	 */
	String key() default "";

	/**
	 * Key的prefix
	 *
	 * @return String
	 */
	String prefix() default "";

	/**
	 * 给定的时间段
	 * 单位秒
	 *
	 * @return int
	 */
	int period();

	/**
	 * 最多的访问限制次数
	 *
	 * @return int
	 */
	int count();

	/**
	 * 类型
	 *
	 * @return LimitType
	 */
	LimitType limitType() default LimitType.CUSTOMER;
}

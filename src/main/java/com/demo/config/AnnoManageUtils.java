package com.demo.config;

import com.demo.controller.HelloController;
import com.google.common.base.Predicate;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withTypeAssignableTo;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.config
 *
 * @author caofengnian 2019/4/11 0011 14:41
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class AnnoManageUtils {
	public static Map<Integer, String> map = new ConcurrentHashMap<>();

	/*static {
		//反射工具包，指明扫描路径
		Reflections reflections = new Reflections("com.demo");
		reflections.getFieldsAnnotatedWith(Handler.class);

	}*/

	public static void main(String[] args) {
		//反射工具包，指明扫描路径
		Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.demo"))
				.setScanners(new FieldAnnotationsScanner()));
		Set<Field> ids = reflections.getFieldsAnnotatedWith(Handler.class);
		System.out.println(ids);
	}

	//通过eventTypeId，也就是注解的值获取相应处理Handler的类名
	public static String getBeanNameByEventType(Integer eventTypeId) {
		return map.get(eventTypeId);
	}
}

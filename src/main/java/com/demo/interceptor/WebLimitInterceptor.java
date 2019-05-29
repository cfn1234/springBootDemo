package com.demo.interceptor;

import com.demo.LimitType.Limit;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.interceptor
 *
 * @author caofengnian 2019/4/30 0030 10:07
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class WebLimitInterceptor  implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		((HandlerMethod) handler).getMethod();
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
	/**
	 * @Author cfn
	 * @Date 10:35 2019/4/30 0030
	 * @Param [method]
	 * @return boolean
	 * @description: 排除注解
	 **/
	private boolean clearedByAnnotation(Method method){
		Limit clear=method.getAnnotation(Limit.class);
		if(clear!=null){
			if(Arrays.asList(clear.value()).contains(WebLimitInterceptor.class)){
				return true;
			}
		}
		Class clazz=method.getDeclaringClass();
		clear= (Limit) clazz.getDeclaredAnnotation(Limit.class);
		if(clear!=null){
			if(Arrays.asList(clear.value()).contains(WebLimitInterceptor.class)){
				return true;
			}
		}
		return false;
	}
	/**
	 * @return boolean
	 * @Author cfn
	 * @Date 10:50 2019/4/30 0030
	 * @Param [handler]
	 * @description: 判断是否有注解
	 **/
	private boolean judgeAnnotation(Object handler) {
		//判断方法上是否有注解
		boolean is = handler.getClass().isAssignableFrom(HandlerMethod.class);
		if (is) {
			//判断是否有limit注解
			Limit limit = ((HandlerMethod) handler).getMethodAnnotation(Limit.class);
			if (limit == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}

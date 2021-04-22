package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * com.demo.aop
 *
 * @author caofengnian
 * @date 2020-06-30
 */
@Aspect
@Component
public class TransactionAop {
    /**
     * 切入点
     */
    @Pointcut("execution(* com.demo.service.*.*(..))")
    public void pointcut() {
        
    }
   
    @Before("pointcut()")
    public void beginTransaction() {
        System.out.println("before beginTransaction");
    }
    
    @After("pointcut()")
    public void commit() {
        System.out.println("after commit");
    }
    
    @AfterReturning(value = "pointcut()", returning = "returnObject")
    public void afterReturning(JoinPoint joinPoint, Object returnObject) {
        System.out.println("afterReturning");
    }
    
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing afterThrowing  rollback");
    }
    
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("around");
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("around");
        }
    }
}

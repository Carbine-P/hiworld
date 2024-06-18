package com.how2java.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
//@Around(value = "execution(* com.how2java.service.ProductService.*(..))")
// 表示对com.how2java.service.ProductService 这个类中的所有方法进行切面操作
    @Around(value = "execution(* com.how2java.service.ProductService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();//就是将来与某个核心功能编织之后，用于执行核心功能的代码
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
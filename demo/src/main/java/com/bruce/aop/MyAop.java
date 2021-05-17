package com.bruce.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author 李启岚(起冉)
 */
@Slf4j
@Aspect
@Component
public class MyAop {
    /**
     * 测试前置增强，测试参数非空校验，此方法还可完善为携带有注定注解的参数则校验非空校验，不携带则不校验
     * 测试通过 正则匹配 的方式使用AOP
     */
    @Before(value ="execution(public * com.bruce.aop.service..*.*(..))")
    public void before1(JoinPoint joinPoint){
        Map params =  AopHelper.getMethodParams(joinPoint);
        params.forEach((key,value)->{
            if (Objects.isNull(value)) throw new RuntimeException("参数" + key + "不能为空");
        });
        log.info("【测试前置增强：】"+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
    }

    /**
     * 测试后置增强，测试使用target指定目标对象
     */
    @After(value ="target(com.bruce.aop.service.CustomerService)")
    public void after(JoinPoint joinPoint){
        log.info("后置增强AfterAop测试指定目标匹配 " + joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName() + "调用成功");
    }

    /**
     * 测试添加异常，核对后置增强是否被触发
     */
    public void addCustomer(Long customerId, String userName, String address) {
        log.info("调用成功addCustomer，当前请求参数customerId={},userName={},address={}", customerId, userName, address);
        int a = 10 / 0;
    }

    /**
     * 测试环绕增强，环绕增强参数可以为ProceedingJoinPoint，可以调用业务方法
     * 通过注解的形式进行AOP测试
     */
    @Around("@annotation(com.bruce.aop.anno.RunTimeLog)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("【进入环绕增强】触发环绕那个增强开始");
        long startTime = System.currentTimeMillis();
        Object result = null;
        // 通过代理类调用业务逻辑执行
        result = pjp.proceed();
        log.info("【测试环绕增强：】当前方法{}执行成功,调用者为：{}，  此方法运行时间为:{} ms", pjp.getSignature().getName(), pjp.getTarget().getClass().getName(), (System.currentTimeMillis() - startTime));
        return result;
    }

    /**
     * 测试最终增强，
     * @param joinPoint
     */
    @AfterReturning("execution(public * com.bruce.aop.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint){
        log.info("测试最终增强" + joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
    }

}

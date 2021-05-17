package com.bruce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李启岚(起冉)
 */
public class AopHelper {
    /**
     * 获取请求方法的参数
     *
     * @param joinPoint
     */
    public static Map getMethodParams(JoinPoint joinPoint) {
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Map params = new HashMap();
        if (Objects.isNull(names)) return params;
        Object[] values = joinPoint.getArgs();
        for (int i = 0; i < names.length; i++) {
            params.put(names[i], values[i]);
        }
        return params;
    }
}

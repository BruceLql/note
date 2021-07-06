package com.bruce.patterns.proxy;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Data
@RequiredArgsConstructor
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("=====before======");
        Object result = method.invoke(object, args);
        System.out.println("=====after======");
        return result;
    }
}

package com.bruce.patterns.proxy;


import java.lang.reflect.Method;

interface IA {
    String getHelloName();
}

class IAImpl implements IA {

    public String getHelloName() {
        return "Abc";
    }
}

class IA2Impl implements IA {

    public String getHelloName() {
        return null;
    }
}

public class ShowMeBug {
    public static void main(String[] arges) throws Exception {
        IA ia = (IA) createObject(IA.class.getName() + "$getHelloName=Abc");
        System.out.println(ia.getHelloName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName() + "$getTest=Bcd");
        System.out.println(ia.getHelloName()); //方法名不匹配的时候，输出Bcd
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断

    public static Object createObject(String str) throws Exception {
        String[] ss = str.split("\\$");
        String path = ss[0];
        String methods = ss[1];
        String[] split = methods.split("=");
        String methodStr = split[0];

        // 通过传入的方法名的区别，返回不同的实现类
        Class<?> ia = Class.forName(path);
        Method[] iaMethods = ia.getMethods();
        for (int i = 0; i < iaMethods.length; i++) {
            if (iaMethods[i].getName().equals(methodStr)) {
                return new IAImpl();
            }
        }
        return new IA2Impl();
        // throw new Exception("还没有实现的方法");
    }
}


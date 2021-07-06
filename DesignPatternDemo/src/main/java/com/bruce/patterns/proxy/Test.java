package com.bruce.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * @author 李启岚(起冉)
 */
public class Test {

    /**
     * 静态代理总结：
     * 优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。
     * 缺点：我们得为每一个服务都得创建代理类，工作量太大，不易管理。同时接口一旦发生改变，代理类也得相应修改。
     * <p>
     * 动态代理：
     * 注意Proxy.newProxyInstance()方法接受三个参数：
     * ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
     * Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
     * InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 静态代理
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse buyHouse21 = new BuyHouse2Impl(buyHouse);
        buyHouse21.buyHosue();

        // jdk 动态代理
        BuyHouse buyHouse1 = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse1));
        proxyBuyHouse.buyHosue();
        // cglib 动态代理
        BuyHouse buyHouse2 = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse2);
        buyHouseCglibProxy.buyHosue();

    }


}

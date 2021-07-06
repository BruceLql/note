package com.bruce.patterns.proxy;

public class BuyHouse2Impl implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouse2Impl(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }


    public void buyHosue() {
        System.out.println("======before======");
        buyHouse.buyHosue();
        System.out.println("======after======");
    }
}

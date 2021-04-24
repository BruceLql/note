package com.bruce.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 李启岚(起冉)
 */
public class Observer4 implements Observer {

    public void registerSubject(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable observer, Object arg) {
        if (observer instanceof ObjectFor3DFinal) {
            System.out.println("observer2 得到 3D 号码 -->" + ((ObjectFor3DFinal) observer).getMsg() + "我要告诉舍友们。");
        }
        if (observer instanceof ObjectForPE) {
            System.out.println("observer2 得到 PE 号码 -->" + ((ObjectForPE) observer).getMsg() + "我要告诉舍友们。");
        }
    }
}

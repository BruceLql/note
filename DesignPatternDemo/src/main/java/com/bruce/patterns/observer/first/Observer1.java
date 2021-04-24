package com.bruce.patterns.observer.first;

/**
 * @author 李启岚(起冉)
 */
public class Observer1 implements Observer {
    private Subject subject;

    public Observer1(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void update(String msg) {
        System.out.println("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }

}

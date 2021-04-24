package com.bruce.patterns.observer;

import java.util.Observable;

/**
 * @author 李启岚(起冉)
 */
public class ObjectForPE extends Observable {

    /**
     * 体育彩票的号码
     */
    private String msg;

    public String getMsg() {
        return this.msg;
    }

    /**
     * 主题更新消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}

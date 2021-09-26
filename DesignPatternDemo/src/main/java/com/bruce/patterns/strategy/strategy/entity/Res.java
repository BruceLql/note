package com.bruce.patterns.strategy.strategy.entity;

/**
 * @author lin
 * @date 2021/5/20 16:27
 **/
public class Res {
    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Res() {
        code = 200;
        message = "success";
    }
}

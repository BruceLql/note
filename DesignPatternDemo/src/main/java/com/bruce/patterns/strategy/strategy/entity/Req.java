package com.bruce.patterns.strategy.strategy.entity;

/**
 * @author lin
 * @date 2021/5/20 16:17
 **/
public class Req {

    private Integer type;

    private Double childVersion;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getChildVersion() {
        return childVersion;
    }

    public void setChildVersion(Double childVersion) {
        this.childVersion = childVersion;
    }
}

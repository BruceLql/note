package com.bruce.annotation;

import lombok.Data;
import lombok.ToString;

/**
 * @author 李启岚(起冉)
 */
@Data
@ToString
public class User {
    @MyAnnotation
    private String name;
    private String age;
    private String describe;

    public User(String name, String age, String describe) {
        super();
        this.name = name;
        this.age = age;
        this.describe = describe;
    }
}

package com.bruce.annotation;

import java.lang.annotation.*;

/**
 * @author 李启岚(起冉)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Documented
@Inherited
public @interface MyAnnotation {
    String value() default "有注解";
}


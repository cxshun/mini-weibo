package com.miniweibo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author nicolas.chan
 * 2020/8/26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ValidateAuth {

    /**
     * is it necessary to validate jwt token
     * @return true-should，false-should not
     */
    boolean required() default false;

}

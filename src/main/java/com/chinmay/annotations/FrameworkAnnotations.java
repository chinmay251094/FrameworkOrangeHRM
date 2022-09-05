package com.chinmay.annotations;

import com.chinmay.enums.SDET;
import com.chinmay.enums.Groups;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {
    public SDET[] author();

    public Groups[] category();
}

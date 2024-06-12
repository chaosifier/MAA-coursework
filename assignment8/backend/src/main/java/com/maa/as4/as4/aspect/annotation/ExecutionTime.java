package com.maa.as4.as4.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // can only be applied to methods
public @interface ExecutionTime {
    
}

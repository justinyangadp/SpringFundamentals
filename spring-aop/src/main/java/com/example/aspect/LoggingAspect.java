package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//  TODO-03: Annotate this class as an aspect and a component.
@Aspect
@Component
public class LoggingAspect {

    //  TODO-04: The following method will log a message whenever a specific method is called.
    //  Annotate the method with an advice type triggered before a target method is called.
    //  Supply a pointcut which selects any method starting with "get*" in the com.example.dao package.
    //  We do not care about the parameters or return type of the target method.
    //  The "Examples" section in https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
    //  has similar examples you may find useful.
    @Before("execution(* com.example.dao.*.get*(..))")
    public void logActivity(JoinPoint joinPoint) {
    
        //  TODO-05: Alter the following line defining "methodName". 
        //  Use the joinPoint parameter to get the name of the method being called.
        //  The name will be used to log the name of the method to the console.
        String methodName = joinPoint.getSignature().getDeclaringTypeName() +
                "." +
                joinPoint.getSignature().getName();

        System.out.println("The " + methodName + " method was called.");
    }

    //  TODO-06: Organize your imports, save your work.  Move on to the next step.
    //  Yup

}

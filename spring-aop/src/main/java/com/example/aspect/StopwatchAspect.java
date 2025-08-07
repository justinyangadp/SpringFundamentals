package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//  TODO-10: (OPTIONAL) Annotate this class as an aspect and a component.

public class StopwatchAspect {

    //  TODO-11: (OPTIONAL) The following method will record how long a method takes to execute.
    //  Annotate the method with an advice type capable of capturing the current time before and after a method is called.
    //  Supply a pointcut selecting any method starting with "save*" in the com.example.dao package.
    //  The "Examples" section in https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
    //  has similar examples you may find useful.

    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
    
        //  TODO-12: (OPTIONAL) Instantiate a new Stopwatch object and call its start() method.
        //  (The Stopwatch class is an inner class provided below.)


        Object result = null;
        try {
            //  TODO-13: (OPTIONAL) Alter the following line of code. 
            //  Use the joinpoint parameter to call the target method on the target object.
            //  Assign the result to the result variable.
            result = null; 
            
        } catch (Throwable e) {
            //  Re-throw the exception so this aspect does not 
            //  interfere with the normal flow of the application.
            throw e;

        } finally {
            String methodName = 
                joinPoint.getSignature().getDeclaringTypeName() + 
                "." + 
                joinPoint.getSignature().getName();

            //  TODO-14: (OPTIONAL) Call the stop() method on the stopwatch object.
            //  Call the stopwatch's displayElapsedTime() method, passing the methodName defined above.
            //  (Notice how the methodName is derived above):

        }
        return result;
    }

    //  TODO-15: (OPTIONAL) Organize your imports, save your work.  Move on to the next step.
    

    // Stopwatch logic.
    private static class Stopwatch {
        private long start;
        private long elapsedTime;

        public void start() {
            start = System.currentTimeMillis();
        }

        public void stop() {
            elapsedTime = System.currentTimeMillis() - start;
        }

        public double getElapsedTime() {
            if (elapsedTime == 0) {
                return (System.currentTimeMillis() - start) / 1000.0;
            }
            return elapsedTime / 1000.0;
        }

        public void displayElapsedTime(String methodName) {
            System.out.println("Elapsed time for " + methodName + " is " + getElapsedTime() + " seconds");
        }
    }

}

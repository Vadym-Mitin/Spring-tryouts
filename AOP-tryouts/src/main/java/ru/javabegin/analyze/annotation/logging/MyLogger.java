package ru.javabegin.analyze.annotation.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Vadym Mitin
 */
@Aspect
@Component
public class MyLogger {

    @Pointcut("execution(**(..)) && within(ru.javabegin.analyze.annotation.objects.*)")
    private void allMethods(){

    }

    @Around("allMethods()")
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        System.out.println("method begin: " + joinpoint.getSignature().toShortString());
        long start = 0L;
        long time = 0L;
        Object output = null;
        try {
            start = System.currentTimeMillis();
            output = joinpoint.proceed();
            time = System.currentTimeMillis();
            time = time - start;
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");

        return output;
    }

    @AfterReturning(pointcut = "allMethods()", returning = "source")
    public void print(Object source){

    }

}

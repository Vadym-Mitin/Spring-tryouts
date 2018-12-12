package com.prospring4.simple.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Vadym Mitin
 */
public class MessageDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("hello ");
        Object proceed = methodInvocation.proceed();
        System.out.println("!");
        return proceed;
    }
}

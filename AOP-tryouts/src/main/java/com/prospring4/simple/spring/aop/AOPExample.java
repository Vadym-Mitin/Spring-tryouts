package com.prospring4.simple.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Vadym Mitin
 */
public class AOPExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        MessageWriter proxy = (MessageWriter) pf.getProxy();
//        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }
}

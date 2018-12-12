package com.apress.prospring4.ch4.factory.bean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class FactoryExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:com/apress/prospring4/ch4/MessageDigest.xml");
        ctx.refresh();
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");
    }
}

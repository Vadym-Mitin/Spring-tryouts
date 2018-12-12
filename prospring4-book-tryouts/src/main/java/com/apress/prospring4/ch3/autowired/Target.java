package com.apress.prospring4.ch3.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class Target {

    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
        System.out.println("constructor without parameters");
    }

    public Target(Foo foo) {
        System.out.println("constructor Foo called: " + foo.toString());
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("constructor Foo Bar called: " + bar.toString() + " " + foo.toString());

    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("setter foo: " + foo.toString());
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        System.out.println("setter foo2: " + foo2.toString());
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("setter bar: " + bar.toString());
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/apress/prospring4/ch3/autowired/autowired.xml");
        Target t = null;

        System.out.println("Using byName:");
        t = ctx.getBean("targetByName", Target.class);
        System.out.println("___________________\nUsing byType:");
        t = ctx.getBean("targetByType", Target.class);
        System.out.println("___________________\nUsing constructor:");
        t = ctx.getBean("targetConstructor", Target.class);
    }
}


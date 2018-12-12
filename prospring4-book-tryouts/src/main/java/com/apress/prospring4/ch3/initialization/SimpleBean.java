package com.apress.prospring4.ch3.initialization;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class SimpleBean implements BeanNameAware {
    private String beanName;

    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean"); // инициализация бина
        if (name == null) {
            System.out.println("Using default name");
            // использование стандартного имени
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Уои must set the age property of any beans of type "
                            // Должно быть установлено свойство age любого бина типа
                            + SimpleBean.class);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBean bean = ctx.getBean(beanName, SimpleBean.class);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occurred in bean configuration: "
                    + ex.getMessage()); // В конфигурации бина произошла ошибка
            return null;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:com/apress/prospring4/ch3/initialization/initialization.xml");
        ctx.refresh();
        SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);

        //The exception will be thrown because the age parameter is not initialized
        SimpleBean simpleBeanЗ = getBean("simpleBeanЗ", ctx);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
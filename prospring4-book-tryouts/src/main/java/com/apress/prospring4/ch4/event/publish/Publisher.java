package com.apress.prospring4.ch4.event.publish;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class Publisher implements ApplicationContextAware {
    private ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.context = applicationContext;
    }

    public void publish(String message) {
        context.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/apress/prospring4/ch4/Event-Publish-context.xml");

        Publisher publisher = ctx.getBean("publisher", Publisher.class);

        publisher.publish("Hello World");
        publisher.publish("The quick brown fox j umped over the lazy dog");
    }
}

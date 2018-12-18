package com.apress.prospring4.ch9;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TxAnnotationSample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:/tx-annotation-app-context.xml");
//        ctx.refresh();
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/apress/prospring4/ch9/tx-annotation-app-context.xml");

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:com/apress/prospring4/ch9/tx-annotation-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService",
                ContactService.class);

        List<Contact> contacts = contactService.findAll();

        for (Contact contactTemp : contacts) {
            System.out.println(contactTemp);
        }

        Contact contact = contactService.findById(1L);
//        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);
        System.out.println("Contact count: " + contactService.countAll());
    }
}

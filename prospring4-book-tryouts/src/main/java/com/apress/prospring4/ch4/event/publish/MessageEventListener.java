package com.apress.prospring4.ch4.event.publish;

import org.springframework.context.ApplicationListener;

/**
 * @author Vadym Mitin
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("message received: " + event.getMessage());
    }
}

package com.apress.prospring4.ch4.event.publish;

import org.springframework.context.ApplicationEvent;

/**
 * @author Vadym Mitin
 */
public class MessageEvent extends ApplicationEvent {
    String message;

    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

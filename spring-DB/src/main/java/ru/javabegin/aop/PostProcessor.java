package ru.javabegin.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Vadym Mitin
 */
@Component
public class PostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
        System.err.println(object + " - postProcessAfterInitialization()");
        return object;
    }

    @Override
    public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
        return object;
    }

}


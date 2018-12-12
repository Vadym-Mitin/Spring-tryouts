package ru.javabegin.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.aop.objects.SomeService;

/**
 * @author Vadym Mitin
 */
public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru/javabegin/aop/context.xml");
        SomeService service = (SomeService) context.getBean("someService");
        double val = service.getDoubleValue();
        service.division(5, 2);
        service.division(0, 0);

        ((ConfigurableApplicationContext) context).close();// закрытие контекста вручную

    }
}

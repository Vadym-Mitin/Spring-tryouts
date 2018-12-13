package app.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaComponentConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaComponentConfig.class);
        MessageRenderer renderer = context.getBean("simpleMessageRenderer", MessageRenderer.class);
        MessageProvider provider = context.getBean("internetMessageProvider", MessageProvider.class);
        renderer.setMessageProvider(provider);
        renderer.render();
    }
}

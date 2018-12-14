package jug.spring.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
@Configuration
@ComponentScan(basePackages = "jug.spring.screensaver")
public class Config {

    @Bean
    @Scope("periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

    }

    @Bean
    @Scope("singleton")
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

//    @Bean
//    public CustomScopeRegisteryBeanFactoryPostProcessor scopeProcessor() {
//        return new CustomScopeRegisteryBeanFactoryPostProcessor();
//    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        while (true) {
            Thread.sleep(100);
            context.getBean(ColorFrame.class).showOnRandomPlace();
        }
    }
}

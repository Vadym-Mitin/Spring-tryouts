package jug.spring.screensaver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
//@Configuration
//@ComponentScan(basePackages = "jug.spring.screensaver")
public class MainConfig {

//    @Bean
//    @Scope("periodical")
//    public Color color() {
//        Random random = new Random();
//        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
//
//    }
//
//    @Bean
//    @Scope("singleton")
//    public ColorFrame frame() {
//        return new ColorFrame() {
//            @Override
//            protected Color getColorForFrame() {
//                return color();
//            }
//        };
//    }

    public static void main(String[] args) throws InterruptedException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("jug.spring.ripper/swing-context.xml");

        while (true) {
            Thread.sleep(100);
            context.getBean(ColorFrame.class).showOnRandomPlace();
        }
    }
}

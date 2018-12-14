package jug.spring.ripper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("jug.spring.ripper/context.xml");

//        while (true) {
//            Thread.sleep(500);
//            Quoter terminator = con.getBean("terminator", Quoter.class);
//            terminator.sayQuote();
//        }

        con.getBean("terminator", Quoter.class).sayQuote();

    }

}

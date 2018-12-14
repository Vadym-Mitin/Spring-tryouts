package jug.spring.ripper;

import javax.annotation.PostConstruct;

/**
 * @author Vadym Mitin
 */
public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
//    @PostConstruct
    public void sayQuote() {
        System.out.println("Я ЖИДКИЙ!");
    }
}

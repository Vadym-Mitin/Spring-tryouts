package jug.spring.ripper;

import javax.annotation.PostConstruct;

/**
 * https://www.youtube.com/watch?v=BmBr5diz8WA
 *
 * @author Vadym Mitin
 */
@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2: init method (@PostConstruct)");
        System.out.println("repeat = " + repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1: standard constructor");
        System.out.println("repeat = " + repeat);
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);

        }

    }
}

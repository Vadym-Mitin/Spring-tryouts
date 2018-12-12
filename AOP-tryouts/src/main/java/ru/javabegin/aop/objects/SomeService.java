package ru.javabegin.aop.objects;

import org.springframework.stereotype.Component;

/**
 * @author Vadym Mitin
 */
@Component
public class SomeService {
    public int getIntValue() {
        return 5;
    }

    public double division(double divisor, double divident) {
        return 5 / 0;
    }

    public double getDoubleValue() {
        return 5.6;
    }
}

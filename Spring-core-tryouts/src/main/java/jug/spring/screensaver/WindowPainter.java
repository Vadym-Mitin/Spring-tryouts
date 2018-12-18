package jug.spring.screensaver;

import java.awt.*;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
//@Component
//@Scope("prototype")
public class WindowPainter extends Color {
    private Color color;
    private static Random rnd = new Random();

    public WindowPainter() {
        super(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));

//        this.color = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
    }

    //    @Override
    public Color getColor() {
//        return color;
        Random rnd = new Random();
        return new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
    }
}

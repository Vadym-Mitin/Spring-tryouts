package jug.spring.screensaver;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
//@Component
//@Scope("singleton")
public abstract class ColorFrame extends JFrame {
    @Autowired
    WindowPainter painter;

    public ColorFrame() throws HeadlessException {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1600), random.nextInt(900));
        getContentPane().setBackground(getPainter());
        repaint();
    }

    protected abstract WindowPainter getPainter();

//    protected abstract Color getColor();

}

package jug.spring.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
@Component
//@Scope("singleton")
public abstract class ColorFrame extends JFrame {

//    private Color color;
//
//    @Autowired
//    public void setColor(Color color) {
//        this.color = color;
//    }

    public ColorFrame() throws HeadlessException {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1600), random.nextInt(900));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();

}

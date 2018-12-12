package todo.ui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vadym Mitin
 */
public class MainFrame extends JFrame implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));
        setVisible(true);
        setState(Frame.NORMAL);
    }


}

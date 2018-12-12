package todo.ui.button;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Vadym Mitin
 */
public class ActionListenerButton extends JButton implements InitializingBean {
    private ActionListener actionListener;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.addActionListener(actionListener);
    }
}

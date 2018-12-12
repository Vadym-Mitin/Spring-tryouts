package todo.ui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Vadym Mitin
 */
public class BoxLayoutPanel extends JPanel implements InitializingBean {
    private List<Component> panelComponents;
    private int axis;

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void setAxis(int axis) {
        this.axis = axis;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setLayout(new BoxLayout(this, axis));

        for (Component panelComponent : panelComponents) {
            this.add(panelComponent);
        }
    }
}

package todo.ui.button;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Vadym Mitin
 */
public abstract class ListTableActionListener implements ActionListener {
    protected JTable table;
    protected List<List> list;

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setList(List list) {
        this.list = list;
    }

    public JTable getTable() {
        return table;
    }

    public List getList() {
        return list;
    }

}

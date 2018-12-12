package todo.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Vadym Mitin
 */
public class ItemTableModel extends AbstractTableModel {
    private List itemList;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        return "Items";
    }

    public void setItemList(List itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getRowCount() {
        return itemList.size();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        itemList.set(rowIndex, value);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return itemList.get(rowIndex);
    }
}

package todo.ui.button;

import java.awt.event.ActionEvent;

/**
 * @author Vadym Mitin
 */
public class DeleteButtonActionListener extends ListTableActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        int listBound = list.size() - 1;

        boolean isTablefilled = table.getRowCount() > 0;
        boolean tableNotEditing = !table.isEditing();
        boolean rightRowSelect = selectedRow >= 0;

        if (rightRowSelect && tableNotEditing && isTablefilled) {
            if (listBound >= selectedRow) {
                list.remove(selectedRow);
                table.revalidate();
            }
        }
    }
}

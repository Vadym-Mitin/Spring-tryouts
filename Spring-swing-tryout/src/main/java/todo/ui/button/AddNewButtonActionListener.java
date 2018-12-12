package todo.ui.button;

import java.awt.event.ActionEvent;
import java.util.Collections;

import static java.util.Collections.singletonList;

/**
 * @author Vadym Mitin
 */
public class AddNewButtonActionListener extends ListTableActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        list.add(singletonList("New item"));
        table.revalidate();
    }
}

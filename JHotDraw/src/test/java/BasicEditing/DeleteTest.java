/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing;

import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import static junit.framework.Assert.assertEquals;
import org.jhotdraw.app.action.DeleteAction;
import org.junit.Test;

/**
 *
 * @author Naimo Ibrahim
 */
public class DeleteTest {

    private final DeleteAction delete = new DeleteAction();
    private final String ID = "edit.delete";
    private final String stringtext = "This delete function works";
    private ActionEvent evt;
    private JTextArea textarea;

    public DeleteTest() {

    }

    @Test
    public void testDeleteAction() {
        textarea = new JTextArea(stringtext);
        textarea.selectAll();
        
        evt = new ActionEvent(textarea, ActionEvent.ACTION_PERFORMED, ID);
        delete.actionPerformed(evt);

        assertEquals(textarea.getText(), "");
    }
}
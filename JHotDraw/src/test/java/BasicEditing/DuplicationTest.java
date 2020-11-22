/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing;

import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static junit.framework.Assert.assertEquals;
import org.jhotdraw.app.action.DuplicateAction;
import org.junit.Test;

/**
 *
 * @author Naimo Ibrahim
 */
public class DuplicationTest {
    
    private final DuplicateAction duplication = new DuplicateAction();
    private final String ID = "edit.duplicate";
    private ActionEvent evt;
    private JTextArea textarea;
    private String firststring;
    
    public DuplicationTest(){
        
    }
    
    @Test
    public void testDuplicateAction(){
        firststring = "This duplication function works!";        
        textarea = new JTextArea(firststring);
        textarea.selectAll();
        
        evt = new ActionEvent(textarea, ActionEvent.ACTION_PERFORMED, ID);
        duplication.actionPerformed(evt);
        
        assertEquals(textarea.getText(), firststring);

    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDuplicate;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JTextArea;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhotdraw.app.action.DuplicateAction;

/**
 *
 * @author Naimo Ibrahim
 */
public class ThenICanDuplicateIt extends Stage<ThenICanDuplicateIt>{
   
    @ExpectedScenarioState
    public JTextArea item = new JTextArea();
    public DuplicateAction duplicate = new DuplicateAction();
    public ActionEvent evt;
    public String ID = "edit.duplicate";

    public ThenICanDuplicateIt I_can_duplicate_it() throws UnsupportedFlavorException, IOException{
        evt = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, ID);
        duplicate.actionPerformed(evt);
        assertThat(item.getText().equals("This duplicate function worksThis duplicate function works"));
        return self();        
    }
}

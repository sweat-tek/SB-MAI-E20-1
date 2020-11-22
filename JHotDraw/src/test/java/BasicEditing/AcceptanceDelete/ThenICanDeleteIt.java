/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDelete;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhotdraw.app.action.DeleteAction;

/**
 *
 * @author Naimo Ibrahim
 */
public class ThenICanDeleteIt extends Stage<BasicEditing.AcceptanceDelete.ThenICanDeleteIt> {

    @ExpectedScenarioState
    public DeleteAction delete = new DeleteAction();
    public String text = "This delete function works.";
    public JTextArea item = new JTextArea(text);
    public String ID = "edit.delete";
    public ActionEvent evt;
    
    public BasicEditing.AcceptanceDelete.ThenICanDeleteIt I_can_delete_it(){
        evt = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, ID);
        delete.actionPerformed(evt);

        assertThat(item.getText().trim().isEmpty());
        return self(); 
    }
}

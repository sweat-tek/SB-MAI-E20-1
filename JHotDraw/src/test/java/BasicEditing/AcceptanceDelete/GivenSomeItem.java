/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDelete;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.JTextArea;

/**
 *
 * @author Naimo Ibrahim
 */
public class GivenSomeItem extends Stage<BasicEditing.AcceptanceDelete.GivenSomeItem> {

    @ProvidedScenarioState
    public JTextArea item;
    public String text = "This delete function works!";

    public BasicEditing.AcceptanceDelete.GivenSomeItem some_item() {
        item = new JTextArea(text);
        return self();
    }
}

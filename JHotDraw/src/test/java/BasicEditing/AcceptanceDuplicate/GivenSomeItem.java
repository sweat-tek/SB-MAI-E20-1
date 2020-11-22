/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDuplicate;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.JTextArea;

/**
 *
 * @author Naimo Ibrahim
 */
public class GivenSomeItem extends Stage <GivenSomeItem> {
    
    @ProvidedScenarioState
    public JTextArea item;
    
    public GivenSomeItem some_item(){
        String textstring ="This duplicate function works";
        item = new JTextArea(textstring);
        return self();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDuplicate;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import javax.swing.JTextArea;
/**
 *
 * @author Naimo Ibrahim
 */
public class WhenISelectTheItem extends Stage<WhenISelectTheItem> {
    
    @ExpectedScenarioState
    public JTextArea item;
    
    public WhenISelectTheItem I_select_the_item(){
        item.selectAll();
        return self();
    }
}

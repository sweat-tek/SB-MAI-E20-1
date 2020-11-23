/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDelete;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Naimo Ibrahim
 */
public class DeleteAcceptanceTest extends ScenarioTest <BasicEditing.AcceptanceDelete.GivenSomeItem, 
        BasicEditing.AcceptanceDelete.WhenISelectTheItem, BasicEditing.AcceptanceDelete.ThenICanDeleteIt> {
    
    @Test
    public void delete(){
        given().some_item();
        when().I_select_the_item();
        then().I_can_delete_it();
    }
    
}

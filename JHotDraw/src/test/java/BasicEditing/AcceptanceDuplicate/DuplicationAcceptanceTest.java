/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicEditing.AcceptanceDuplicate;

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author Naimo Ibrahim
 */
public class DuplicationAcceptanceTest extends ScenarioTest <GivenSomeItem, WhenISelectTheItem, ThenICanDuplicateIt> {

    @Test
    public void duplication() throws UnsupportedFlavorException, IOException {
        
        given().some_item();
        when().I_select_the_item();
        then().I_can_duplicate_it();
        
    }

}

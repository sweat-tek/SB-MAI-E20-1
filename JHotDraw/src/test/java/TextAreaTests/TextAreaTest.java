package TextAreaTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
/**
 *
 * @author askel
 */
public class TextAreaTest extends ScenarioTest<GivenTextArea, WhenTextAreaIsSelected, ThenTextAreaContainsText> {
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void textAreaIsSelctedAndWrittenIn(){
        given().aTextArea();
        
        when().textAreaSelected().and().TextIsWritten();
        
        then().textAreaIsSelected().and().textAreaContainsWrittentext();
        
    }
}

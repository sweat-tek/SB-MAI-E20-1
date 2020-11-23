/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;


import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author hala_
 */
public class ExitAppScenarioTest extends ScenarioTest<GivenAnOpenWindow, WhenWantToExit, ThenExitWindow>{
    
    @Test
    public void exitOpenWindow() {
        given().givenAnOpenWindow();
        when().whenWantToExit();
        then().thenExitWindow();
    }
}

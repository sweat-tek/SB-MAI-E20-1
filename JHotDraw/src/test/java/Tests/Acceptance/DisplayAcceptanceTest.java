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
 * @author NidaBasaran
 */
public class DisplayAcceptanceTest extends ScenarioTest<GivenAToolBar, WhenAddAComponent, ThenToolBarHasComponents> {

    @Test
    public void display() {

        given().AToolbar();
        when().addAComponent();
        then().toolBarHasComponents();

    }

}

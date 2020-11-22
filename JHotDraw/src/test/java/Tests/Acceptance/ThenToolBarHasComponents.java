/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.gui.ToolsToolBar;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author NidaBasaran
 */
public class ThenToolBarHasComponents extends Stage<ThenToolBarHasComponents> {

    @ExpectedScenarioState
    private ToolsToolBar toolBar;

    public ThenToolBarHasComponents toolBarHasComponents() {
        int numberOfComponents = this.toolBar.getComponents().length;
        System.out.println("sdasda" + numberOfComponents);
        assertTrue(numberOfComponents > 0);
        return this;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhotdraw.gui.JDisclosureToolBar;


/**
 *
 * @author NidaBasaran
 */
public class ThenTheToolPaletteShouldBeDisplayed extends Stage<ThenTheToolPaletteShouldBeDisplayed> {
    
    @ExpectedScenarioState
    Exception exception;
    
    public ThenTheToolPaletteShouldBeDisplayed thenTheToolPaletteShouldBeDisplayed() {
        assertThat(exception = null);
        return self();
    }
    
    
}

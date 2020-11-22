/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.JButton;
import org.jhotdraw.gui.JDisclosureToolBar;
import static org.mockito.Mockito.mock;

///**
// *
// * @author NidaBasaran
// */
public class GivenIAmAUserOfJHotDraw extends Stage<GivenIAmAUserOfJHotDraw> {
    
    @ProvidedScenarioState
//    JDisclosureToolBar toolbar = mock(JDisclosureToolBar.class);
    JButton disclosureButton;
    
    public GivenIAmAUserOfJHotDraw iAmAUserOfJHotDraw() {
        disclosureButton = new JButton();
        return self();
    }   
}

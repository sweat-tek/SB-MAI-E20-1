/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import javax.swing.JButton;
import org.jhotdraw.gui.JDisclosureToolBar;
/**
 *
 * @author NidaBasaran
 */
public class WhenIStartJHotDraw extends Stage<WhenIStartJHotDraw> {
    
    @ExpectedScenarioState
    protected JButton; 
    
    public WhenIStartJHotDraw iStartJHotDraw() {
        toolbar.getDisclosureState();
        toolbar.getDisclosureStateCount();
        
        return self();
    }
    
}

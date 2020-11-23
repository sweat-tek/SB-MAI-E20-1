package viewPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.GridConstrainer;

/**
 *
 * @author emili
 */
public class WhenGridSelected extends Stage<WhenGridSelected> {
    
    @ProvidedScenarioState
    GridConstrainer grid = new GridConstrainer();
    
    public void gridIsSelected(){
        grid.setVisible(true);
    }
}

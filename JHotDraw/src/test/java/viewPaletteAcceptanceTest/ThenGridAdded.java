package viewPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.GridConstrainer;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author emili
 */
public class ThenGridAdded extends Stage<ThenGridAdded> {
    
    @ExpectedScenarioState
    GridConstrainer grid = new GridConstrainer();
    
    @ProvidedScenarioState
    Boolean visible = true;
    
    public ThenGridAdded gridIsAdded(){
        assertTrue(grid.isVisible() == visible);
        return self();
    }
}

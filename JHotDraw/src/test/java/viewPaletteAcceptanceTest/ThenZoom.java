package viewPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author emili
 */
public class ThenZoom extends Stage<ThenZoom> {
        
    @ExpectedScenarioState
    private DefaultDrawingEditor editor;
    
    @ExpectedScenarioState
    private double scaleFactor = 4.00;
    
    public ThenZoom zoomHappens(){
        assertEquals(editor.getActiveView().getScaleFactor(), scaleFactor, 0);
        return self();
    }
}
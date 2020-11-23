package viewPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;

/**
 *
 * @author emili
 */
public class WhenZoom extends Stage<WhenZoom> {
    
    @ExpectedScenarioState
    private DefaultDrawingEditor editor;
    
    @ProvidedScenarioState
    private double scaleFactor = 4.00;
    
    public void zoomIsChanged(){
        editor.getActiveView().setScaleFactor(scaleFactor);
    }
}

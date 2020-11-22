package viewPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;

/**
 *
 * @author emili
 */
public class GivenCanvas extends Stage<GivenCanvas> {
    
    @ProvidedScenarioState
    DefaultDrawingEditor editor;
    
    public GivenCanvas aViewIsCreated(){
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
        return this;
    }
}

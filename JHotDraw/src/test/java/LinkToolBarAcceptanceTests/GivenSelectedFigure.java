package LinkToolBarAcceptanceTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;

public class GivenSelectedFigure extends Stage<GivenSelectedFigure> {

    @ProvidedScenarioState
    BezierFigure selectedBezierFigure;
    @ProvidedScenarioState
    DefaultDrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    public GivenSelectedFigure aSelectedFigure() {
        BezierFigure f1 = new BezierFigure();
         editor.getActiveView().getDrawing().add(f1);
        selectedBezierFigure = f1;
        return this;
    }
}

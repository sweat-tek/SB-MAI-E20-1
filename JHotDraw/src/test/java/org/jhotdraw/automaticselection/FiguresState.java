package org.jhotdraw.automaticselection;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.LineFigure;
import org.junit.Assert;

public class FiguresState extends Stage<FiguresState> {

    @ProvidedScenarioState
    private final DefaultDrawingView defaultDrawingView;

    @ProvidedScenarioState
    private final int numberOfFigures = 10;

    public FiguresState() {
        defaultDrawingView = new DefaultDrawingView();
        defaultDrawingView.setDrawing(new DefaultDrawing());
        for (int i = 0; i < numberOfFigures; i++) {
            defaultDrawingView.getDrawing().add(new LineFigure());
        }
    }

    public FiguresState figures_drawn() {
        Assert.assertNotNull(defaultDrawingView.getDrawing());
        Assert.assertEquals(numberOfFigures, defaultDrawingView.getDrawing().getChildren().size());
        return self();
    }
}

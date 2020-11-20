package org.jhotdraw.automaticselection;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.junit.Assert;

public class FiguresSelectedOutcome extends Stage<FiguresSelectedOutcome> {

    @ExpectedScenarioState
    private DefaultDrawingView defaultDrawingView;

    @ExpectedScenarioState
    private int numberOfFigures;

    public FiguresSelectedOutcome figures_are_selected() {
        Assert.assertEquals(numberOfFigures, defaultDrawingView.getSelectionCount());
        return self();
    }
}

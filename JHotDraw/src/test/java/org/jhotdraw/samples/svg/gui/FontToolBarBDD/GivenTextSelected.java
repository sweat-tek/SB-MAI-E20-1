package org.jhotdraw.samples.svg.gui.FontToolBarBDD;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Assert;

public class GivenTextSelected extends Stage<GivenTextSelected> {
    @ProvidedScenarioState
    private final DefaultDrawingView view;

    public GivenTextSelected() {
        view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
        view.getDrawing().add(new SVGTextFigure("test text"));
        view.selectAll();
    }

    public GivenTextSelected text_selected() {
        Assert.assertNotNull(view.getDrawing());
        Assert.assertEquals(1, view.getSelectionCount());
        return self();
    }
}
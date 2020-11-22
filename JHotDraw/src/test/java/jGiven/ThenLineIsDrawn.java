package jGiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.awt.Color;
import java.awt.Graphics2D;

import static org.junit.Assert.assertEquals;

public class ThenLineIsDrawn extends Stage<ThenLineIsDrawn> {
    @ExpectedScenarioState
    SVGPathFigure svgPathFigure;
    @ExpectedScenarioState
    Graphics2D g;
    @ExpectedScenarioState
    Color color;

    public ThenLineIsDrawn lineIsDrawnInCorrectColor() {
        assertEquals(color, g.getPaint());
        return self();
    }
}

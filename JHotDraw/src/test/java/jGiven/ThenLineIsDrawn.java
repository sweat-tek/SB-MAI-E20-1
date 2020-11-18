package jGiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.awt.Graphics2D;

import static org.junit.Assert.assertEquals;

public class ThenLineIsDrawn extends Stage<ThenLineIsDrawn> {
    @ExpectedScenarioState
    SVGPathFigure svgPathFigure;
    @ExpectedScenarioState
    Graphics2D g;

    public ThenLineIsDrawn lineIsDrawnInCorrectColor() {
        assertEquals(svgPathFigure.getAttribute(AttributeKeys.FILL_COLOR), g.getPaint());
        return self();
    }
}

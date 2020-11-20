package LinkToolBarAcceptanceTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.BezierFigure;

import static org.junit.Assert.assertEquals;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK_TARGET;

public class ThenLinkIsAddedToFigure extends Stage<ThenLinkIsAddedToFigure> {

    @ExpectedScenarioState
    String link = "google.dk";
    @ExpectedScenarioState
    String target = "_";
    @ExpectedScenarioState
    BezierFigure selectedBezierFigure;

    public ThenLinkIsAddedToFigure linkIsAddedToFigure() {
        BezierFigure result = selectedBezierFigure;

        // ensuring that the link is google.dk
        assertEquals(link, result.getAttribute(LINK));

        // ensuring that the link target is correct (_)
        assertEquals(target, result.getAttribute(LINK_TARGET));

        return self();
    }
}

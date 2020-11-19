package LinkToolBarAcceptanceTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK_TARGET;

public class WhenLinkInserted extends Stage<WhenLinkInserted> {
    @ProvidedScenarioState
    String link = "google.dk";
    @ProvidedScenarioState
    String target = "_"; // Open google.dk in a new tab

    @ExpectedScenarioState
    BezierFigure bezierFigure;

    public WhenLinkInserted linkInserted() {

        GivenSelectedFigure selectedFigure = new GivenSelectedFigure();

        selectedFigure.selectedFigure();
        addLinkToFigure();

        return self();
    }

    public void addLinkToFigure() {
        // The link and target are just two attributs on the bezierfigure
        bezierFigure.setAttribute(LINK, link);
        bezierFigure.setAttribute(LINK_TARGET, target);
    }
}

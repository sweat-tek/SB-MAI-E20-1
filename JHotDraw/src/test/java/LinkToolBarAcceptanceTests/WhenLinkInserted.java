package LinkToolBarAcceptanceTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK_TARGET;

public class WhenLinkInserted extends Stage<WhenLinkInserted> {

    @ProvidedScenarioState
    private String link = "google.dk";
    @ProvidedScenarioState
    private String target = "_"; // Open google.dk in a new tab

    @ProvidedScenarioState
    @ExpectedScenarioState
    private BezierFigure selectedBezierFigure;

    public WhenLinkInserted linkInserted() {

        addLinkToFigure();

        return self();
    }

    public void addLinkToFigure() {
        // The link and target are just two attributes on the selectedFigure
        selectedBezierFigure.setAttribute(LINK, link);
        selectedBezierFigure.setAttribute(LINK_TARGET, target);
    }
}

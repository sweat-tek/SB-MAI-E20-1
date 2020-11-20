package LinkToolBarAcceptanceTests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class LinkPaletteAcceptanceTest extends ScenarioTest<GivenSelectedFigure, WhenLinkInserted, ThenLinkIsAddedToFigure> {

    @Test
    public void linkPaletteAcceptanceTest() {
        // As a user, I want to be able to create links on the drawings and text I make,
        // so that I can make interactive drawings
        given().aSelectedFigure();
        when().linkInserted();
        then().linkIsAddedToFigure();
    }
}

package viewPaletteAcceptanceTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author emili
 */
public class GridAcceptanceTest extends ScenarioTest<GivenCanvas, WhenGridSelected, ThenGridAdded> {
           
    @Test
    public void ZoomAcceptanceTest() {
        //As an end user I want to be able to add a grid to the canvas,
        //so that it will be easier to align objects if needed.
        
        given().aViewIsCreated();
        when().gridIsSelected();
        then().gridIsAdded();
    }
}

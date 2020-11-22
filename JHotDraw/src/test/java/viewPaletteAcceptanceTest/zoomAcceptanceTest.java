package viewPaletteAcceptanceTest;

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;

/**
 *
 * @author emili
 */
public class ZoomAcceptanceTest extends ScenarioTest<GivenCanvas, WhenZoom, ThenZoom> {
    
    @Test
    public void ZoomAcceptanceTest(){
        //As an end user I want to be able to zoom in and out,
        //so that it will be easier to see objects if needed.
        
        given().aViewIsCreated();
        when().zoomIsChanged();
        then().zoomHappens();
    }
}

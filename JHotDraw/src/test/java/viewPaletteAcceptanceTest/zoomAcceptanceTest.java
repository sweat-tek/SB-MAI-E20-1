package viewPaletteAcceptanceTest;

import org.junit.Test;


/**
 *
 * @author emili
 */
public class viewPaletteAcceptanceTest {
    
    @Test
    public void vewPaletteAcceptanceTest(){
        //As an end user I want to be able to add a grid to the canvas as well as zoom in and out,
        //so that it will be easier to see and align objects if needed.
        
        given().aCanvasIsCreated();
        when().gridIsSelected();
    }
    
}

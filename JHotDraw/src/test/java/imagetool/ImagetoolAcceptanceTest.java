/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetool;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author nadinfariss
 */
public class ImagetoolAcceptanceTest extends ScenarioTest<GivenAnImageFigure, WhenAnImageIsLoaded, ThenTheImageFigureContainsImageData> {

    @Test
    public void ImagetoolAcceptanceTest() throws IOException {
        // as a [user], I want [to be able to insert an image] so that [I can add it to my canvas].
        given().SelectedImage();
        when().imageInserted();
        then().imageIsAdded();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author nadinfariss
 */
public class ThenTheImageFigureContainsImageData extends Stage<ThenTheImageFigureContainsImageData> {

    @ExpectedScenarioState
    SVGImageFigure image;

    @ProvidedScenarioState
    byte[] expectedImageData;

    public ThenTheImageFigureContainsImageData imageIsAdded() {

        assertNotNull(image.getImageData());
        //when the image is loaded then the image figure contains data. 
        return this;

    }

}

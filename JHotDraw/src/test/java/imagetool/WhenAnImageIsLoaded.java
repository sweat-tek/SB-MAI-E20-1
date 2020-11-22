/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

/**
 *
 * @author nadinfariss
 */
public class WhenAnImageIsLoaded extends Stage<WhenAnImageIsLoaded> {

    @ExpectedScenarioState
    SVGImageFigure image;

    InputStream initialStream;

    @ProvidedScenarioState
    byte[] expectedImageData;

    @BeforeStage
    private void before() throws IOException {
        initialStream = new FileInputStream("/Users/nadinfariss/Desktop/SB-MAI-E20-1/JHotDraw/src/test/java/imagetool/testImage.jpg");

    }

    // then you take the Image and load it.
    public WhenAnImageIsLoaded imageInserted() {

        try {
            this.image.loadImage(this.initialStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this;
    }

}

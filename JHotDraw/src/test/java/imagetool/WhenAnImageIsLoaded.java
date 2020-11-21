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
        //this.expectedImageData = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 1, 0, 0, 0, 1, 8, 6, 0, 0, 0, 31, 21, -60, -119, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 46, 35, 0, 0, 46, 35, 1, 120, -91, 63, 118, 0, 0, 0, 27, 116, 69, 88, 116, 83, 111, 102, 116, 119, 97, 114, 101, 0, 67, 101, 108, 115, 121, 115, 32, 83, 116, 117, 100, 105, 111, 32, 84, 111, 111, 108, -63, -89, -31, 124, 0, 0, 0, 11, 73, 68, 65, 84, 8, -41, 99, -8, 15, 4, 0, 9, -5, 3, -3, 99, 38, -59, -113, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        // that is the bites of the testimage.jpp to test the smallest bytes
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

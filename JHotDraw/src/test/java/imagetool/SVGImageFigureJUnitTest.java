/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetool;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nadinfariss
 */
public class SVGImageFigureJUnitTest {

    SVGImageFigure original;

    @Before
    public void setUp() {
        original = new SVGImageFigure(0, 0, 10, 10);

        try {
            InputStream stream = new FileInputStream("/Users/nadinfariss/Desktop/SB-MAI-E20-1/JHotDraw/src/test/java/imagetool/testImage.jpg");
            this.original.loadImage(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void SVGImageFigureJUnitTest() {
        SVGImageFigure figureClone = original.clone();

        assertEquals(getImageData(original.getImageData()), getImageData(figureClone.getImageData()));
        assertEquals(original.getHeight(), figureClone.getHeight(), 0);
    }

    private String getImageData(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(b);
        }
        return stringBuilder.toString();

    }
}

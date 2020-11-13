package texttool;

import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TextToolTest {

    private SVGTextFigure svgTextFigure;

    @Before
    public void createSvgTextFigure() {
        svgTextFigure = new SVGTextFigure();
    }

    @Test
    public void assertNotNull() {
        assert svgTextFigure != null;
    }

    @Test
    public void testValueOfTextTool() {
        assertEquals("Testing value of a fresh initialized text", "Text", svgTextFigure.getText());
    }

    @Test
    public void testCoordinatesChangedAfterMovingTheText() {
        Point2D.Double[] coordinates = svgTextFigure.getCoordinates();
        svgTextFigure.setCoordinates(new Point2D.Double[]{new Point2D.Double(0, 0)});
        assertNotEquals("Testing text coordinates after moving it", coordinates, svgTextFigure.getCoordinates());
    }

    @Test
    public void testFontSize() {
        float fontSize = svgTextFigure.getFontSize();
        svgTextFigure.setFontSize(Float.MAX_VALUE);
        assertNotEquals("Testing font size to ensure change", fontSize, svgTextFigure.getFontSize());
    }

    @Test
    public void testTextColor() {
        Color textColor = svgTextFigure.getTextColor();
        assert textColor != null;
        assertEquals("Testing default color for text", Color.black, textColor);
    }
}

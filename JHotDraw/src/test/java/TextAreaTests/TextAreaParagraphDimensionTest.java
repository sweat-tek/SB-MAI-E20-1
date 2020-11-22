/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAreaTests;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.Options;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.OPACITY;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jhotdraw.samples.svg.figures.Paragraph;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author askel
 */
public class TextAreaParagraphDimensionTest {
    
    public TextAreaParagraphDimensionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getparagraphTest() {
        GeneralPath shape = null;
        Font font = new java.awt.Font("Verdana",1,12);
        AttributedString as = new AttributedString("Test");
        as.addAttribute(TextAttribute.FONT, font);
        float verticalPos = 2;
        float maxVerticalPos = 282;
        float leftMargin = 350;
        float rightMargin = 517;
        FontRenderContext fontRenderContext = new FontRenderContext(new AffineTransform(), Options.isTextAntialiased(), Options.isFractionalMetrics());
        float[] tabStops = new float[443];      
        int tabCount = 0;
        Rectangle2D.Double paragraphBounds = new Paragraph(
                                    shape, as.getIterator(),
                                    verticalPos, maxVerticalPos, leftMargin, rightMargin, tabStops, tabCount, fontRenderContext).getParagraph();
        //assertEquals("Dimensions of paragraph should be:", paragraphBounds, new Rectangle2D.Double(350.0,2.0,28.470703125,12.251953125));
    }
    @Test
    public void OpaTest(){
        SVGTextAreaFigure textArea = new SVGTextAreaFigure();
        Double opaBefore = textArea.getAttribute(OPACITY);
        Double opop = 0.5;
        textArea.setAttribute(OPACITY, opop);
        Double opaAfter = textArea.getAttribute(OPACITY);
        System.out.println(opaBefore+ "" + opaAfter);
    }
    
    
}

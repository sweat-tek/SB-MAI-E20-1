/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.AttributeKeys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.Action;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author slm
 */
public class SVGPathFigureTest {
    SVGPathFigure svgPathFigure;
    
    public SVGPathFigureTest() {
        svgPathFigure = new SVGPathFigure();
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

    @Test
    public void testConstructor() {
        SVGPathFigure svgPathFigure1 = new SVGPathFigure();
        assertFalse(svgPathFigure1.getChildren().isEmpty());
        assertSame(svgPathFigure1.getChildren().get(0).getClass(), SVGBezierFigure.class);

        SVGPathFigure svgPathFigureEmpty = new SVGPathFigure(true);
        assertTrue(svgPathFigureEmpty.getChildren().isEmpty());
        assertSame(AttributeKeys.WINDING_RULE.get(svgPathFigure), AttributeKeys.WindingRule.NON_ZERO);
        assertSame(AttributeKeys.WINDING_RULE.get(svgPathFigureEmpty), AttributeKeys.WindingRule.NON_ZERO);
    }

    @Test
    public void testGetActions() {
        Point2D.Double p = new Point2D.Double(1, 1);
        Collection<Action> actions = svgPathFigure.getActions(p);
        assertFalse(actions.isEmpty());
        assertEquals(2, actions.size());
        svgPathFigure.setAttribute(AttributeKeys.TRANSFORM, new AffineTransform());
        actions = svgPathFigure.getActions(p);
        // asserting that the number of actions is higher if the TRANSFORM attribute is not null
        assertEquals(4, actions.size());
    }

    @Test
    public void testDraw() {
        svgPathFigure.setAttribute(AttributeKeys.FILL_COLOR, Color.MAGENTA);
        Graphics2D g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics();
        svgPathFigure.draw(g);
        assertEquals(svgPathFigure.getAttribute(AttributeKeys.FILL_COLOR), g.getPaint());
    }
}

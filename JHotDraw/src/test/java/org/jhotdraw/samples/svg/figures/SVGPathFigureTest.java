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
import java.util.Arrays;
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
    Point2D.Double point;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        svgPathFigure = new SVGPathFigure();
        point = new Point2D.Double(1, 1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        SVGPathFigure svgPathFigure1 = new SVGPathFigure();
        // Assert that the constructor adds an SVGBezierFigure object to the list of children.
        assertFalse(svgPathFigure1.getChildren().isEmpty());
        assertSame(svgPathFigure1.getChildren().get(0).getClass(), SVGBezierFigure.class);

        SVGPathFigure svgPathFigureEmpty = new SVGPathFigure(true);
        //Assert that the other constructor doesn't add a figure to the list of children
        assertTrue(svgPathFigureEmpty.getChildren().isEmpty());
        //Assert that the default values have been set correctly on both SVGPathFigures
        assertSame(AttributeKeys.WINDING_RULE.get(svgPathFigure1), AttributeKeys.WindingRule.NON_ZERO);
        assertSame(AttributeKeys.WINDING_RULE.get(svgPathFigureEmpty), AttributeKeys.WindingRule.NON_ZERO);
    }

    @Test
    public void testGetActions() {
        Collection<Action> actions = svgPathFigure.getActions(point);
        assertFalse(actions.isEmpty());
        assertEquals(2, actions.size());

        for (String label : Arrays.asList("Close Path", "Even Odd")) {
            assertTrue(actions.stream().anyMatch(action -> action.getValue(Action.NAME).equals(label)));
        }
    }

    @Test
    public void testGetActionsWithTransformAttribute() {
        svgPathFigure.setAttribute(AttributeKeys.TRANSFORM, new AffineTransform());
        Collection<Action> actions = svgPathFigure.getActions(point);
        assertEquals(4, actions.size());

        for (String label : Arrays.asList("Remove Transformation", "Flatten Transformation", "Close Path", "Even Odd")) {
            assertTrue(actions.stream().anyMatch(action -> action.getValue(Action.NAME).equals(label)));
        }
    }

    @Test
    public void testDraw() {
        svgPathFigure.setAttribute(AttributeKeys.FILL_COLOR, Color.MAGENTA);
        Graphics2D g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics();
        svgPathFigure.draw(g);
        assertEquals(svgPathFigure.getAttribute(AttributeKeys.FILL_COLOR), g.getPaint());
    }
}

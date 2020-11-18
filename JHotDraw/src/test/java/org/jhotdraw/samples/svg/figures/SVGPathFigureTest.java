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
 * @author slm
 */
public class SVGPathFigureTest {
    SVGPathFigure svgPathFigure;
    Point2D.Double point = new Point2D.Double(1, 1);

    @Before
    public void setUp() {
        svgPathFigure = new SVGPathFigure();
    }

    @Test
    public void testConstructor() {
        assertFalse(svgPathFigure.getChildren().isEmpty());
        assertSame(svgPathFigure.getChildren().get(0).getClass(), SVGBezierFigure.class);
        assertSame(AttributeKeys.WINDING_RULE.get(svgPathFigure), AttributeKeys.WindingRule.NON_ZERO);

        SVGPathFigure svgPathFigureEmpty = new SVGPathFigure(true);
        assertTrue(svgPathFigureEmpty.getChildren().isEmpty());
        assertSame(AttributeKeys.WINDING_RULE.get(svgPathFigureEmpty), AttributeKeys.WindingRule.NON_ZERO);
    }

    @Test
    public void testGetActionsDefault() {
        assertActions(svgPathFigure.getActions(point), 2,"Close Path", "Even Odd");
    }

    @Test
    public void testGetActionsWithTransformAttribute() {
        svgPathFigure.setAttribute(AttributeKeys.TRANSFORM, new AffineTransform());
        assertActions(svgPathFigure.getActions(point), 4,
                "Remove Transformation", "Flatten Transformation", "Close Path", "Even Odd");
    }

    @Test
    public void testGetActionsClosedAndEvenOdd() {
        svgPathFigure.getChild(svgPathFigure.getChildCount() - 1)
                .setAttribute(AttributeKeys.CLOSED,true);
        svgPathFigure.setAttribute(AttributeKeys.WINDING_RULE, AttributeKeys.WindingRule.EVEN_ODD);
        assertActions(svgPathFigure.getActions(point),2,"Open Path", "Non Zero");
    }

    private void assertActions(Collection<Action> actions, int numberOfActions, String... labels) {
        assertEquals(numberOfActions, actions.size());
        for (String label : labels) {
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

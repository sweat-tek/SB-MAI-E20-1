/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Collection;
import javax.swing.Action;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import sun.java2d.SunGraphics2D;

/**
 *
 * @author oscar
 */
public class SVGAttributedFigureTest {

    private DrawingEditor editor;
    private Figure ellipseFigure;

    @Mock
    Graphics2D graphicsMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private double size;

    @Before
    public void setUp() {
        this.size = 50;

        this.editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        this.editor.setActiveView(view);
        this.ellipseFigure = new SVGEllipseFigure(0, 0, this.size, this.size);
        this.editor.getActiveView().getDrawing().add(ellipseFigure);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class SVGAttributedFigure.
     */
    @Test
    public void testDraw() {
        assertTrue(this.size == this.ellipseFigure.getBounds().height);

        this.ellipseFigure.draw(graphicsMock);

        assertTrue(this.size == this.ellipseFigure.getBounds().height);

    }

}

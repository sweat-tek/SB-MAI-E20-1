package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.junit.Assert.*;

/**
 *
 * @author DanThai
 */
public class SVGRectFigureTest {
    
    private DrawingEditor editor;
    private SVGRectFigure rectFigure;
    private double size;
    
    @Mock
    Graphics2D graphics2DMock;
    
    @Rule
    MockitoRule mockitoRule = MockitoJUnit.rule();
    
    public SVGRectFigureTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        this.size = 30;
        this.editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        this.editor.setActiveView(view);
        this.rectFigure = new SVGRectFigure(0, 0, this.size, this.size);
        this.editor.getActiveView().getDrawing().add(rectFigure);
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testResizing() {
        
        this.rectFigure.willChange();
        
        Point2D.Double anchor = new Point2D.Double(0, 0);
        Point2D.Double lead = new Point2D.Double(100, 100);
        this.rectFigure.setBounds(anchor, lead);
        
        this.rectFigure.changed();
        
        assertTrue(this.rectFigure.getHeight() == 100);
        assertTrue(this.rectFigure.getWidth() == 100);
        
        this.rectFigure.draw(graphics2DMock);
        
        assertTrue(this.rectFigure.getHeight() == 100);
        assertTrue(this.rectFigure.getWidth() == 100);
        
    }
    
}

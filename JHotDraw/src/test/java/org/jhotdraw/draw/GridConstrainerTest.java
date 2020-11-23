package org.jhotdraw.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author emili
 */
public class GridConstrainerTest {
    
    DefaultDrawingEditor editor;
    GridConstrainer grid;
    Color majorColor = new Color(0xcacaca);

    public GridConstrainerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //Instantiating the EditorColorChooserAction class
        editor = new DefaultDrawingEditor();
        //It needs a view
        DrawingView drawingView = new DefaultDrawingView();
        //The view needs a drawing
        Drawing drawing = new DefaultDrawing();
        drawingView.setDrawing(drawing);
    
        //Applying the active view
        editor.setActiveView(drawingView);
       
        grid = new GridConstrainer();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void draw() {
        // mock a Graphics2D to use a parameter
        Graphics2D g = mock(Graphics2D.class);
        when(g.getClipBounds()).thenReturn(new Rectangle(0, 0, 154, 144));
        
        // grid is Selected
        grid.setVisible(true);

        // draw the grid on the view
        grid.draw(g, editor.getActiveView());
        
        // verify that setColor was called, meaning the grid is being drawn
        verify(g, atLeast(1)).setColor(majorColor);
    }
}

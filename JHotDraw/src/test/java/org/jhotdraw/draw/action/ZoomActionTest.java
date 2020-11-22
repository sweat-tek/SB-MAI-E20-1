package org.jhotdraw.draw.action;

import java.awt.Color;
import java.util.HashMap;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emili
 */
public class ZoomActionTest {

    AttributeAction editorColorChooserAction;
    DefaultDrawingEditor editor;

    public ZoomActionTest() {
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

        editorColorChooserAction = new EditorColorChooserAction(editor, AttributeKeys.FILL_COLOR);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class ZoomAction.
     */
    @Test
    public void actionPerformed() {
        // Imitage choosing a scalefactor
        double scaleFactor = 4.00;
        
        // Change the views scaleFactor
        editor.getActiveView().setScaleFactor(scaleFactor);
        
        // Test that the views scalefactor has changed
        assertEquals(editor.getActiveView().getScaleFactor(), scaleFactor, 0);
    }
}

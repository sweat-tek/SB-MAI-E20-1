/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jhotdraw.samples.svg.gui;

import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.EditorColorChooserAction;
import org.jhotdraw.samples.svg.gui.ViewToolBar;
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
public class ViewToolBarTest {
    
    DefaultDrawingEditor editor;
    
    public ViewToolBarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Instantiating the editor and view
        editor = new DefaultDrawingEditor();
        DrawingView drawingView = new DefaultDrawingView();
        
        //The view needs a drawing
        Drawing drawing = new DefaultDrawing();
        drawingView.setDrawing(drawing);

        //Applying the view to the editor as its active view
        editor.setActiveView(drawingView);
    }
    
    @Test
    public void createDisclosedComponent(){
        // Imitate creating false JPanel
        ViewToolBar vtb = new ViewToolBar();
        vtb.setView(editor.getActiveView());
        JComponent oldP = (JPanel) vtb.createDisclosedComponent(1);
       
        // Change the state to 2
        JPanel newP = (JPanel) vtb.createDisclosedComponent(2);
        
        // Test that the components size changes
        assertTrue(oldP.getComponentCount() < newP.getComponentCount());
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

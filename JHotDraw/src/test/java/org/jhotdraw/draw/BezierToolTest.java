/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryge
 */
public class BezierToolTest {
    
    public BezierToolTest() {
    }
    
    private BezierFigure someFigure;
    private Drawing someDrawing;
    private BezierTool someTool;
    //private DrawingView someView;
    
    
    @Before
    public void setUp() {
           
        System.out.println("Setup");
        
        someFigure = new BezierFigure();
        someTool = new BezierTool(someFigure);
        someDrawing = new DefaultDrawing();
        
        someDrawing.add(someFigure);
        
        assertNotNull(someFigure);
        assertNotNull(someTool);
        assertNotNull(someDrawing);
        assertTrue(someDrawing.getChildren().contains(someFigure));
        
    }
    
    @After
    public void tearDown() {
        System.out.println("Teardown");
        
        someFigure = null;
        someTool = null;
        someDrawing = null;
               
        assertNull(someTool);
        assertNull(someFigure);
        assertNull(someDrawing);
        
    }

    
    @Test
    public void undo() {
        
        System.out.println("Undo");
        
        //Can't call super.undo() from here, but it would appear that
        //all it does is so check for whether the action is undoable or not.
        
        
        //This would seem extremely simplistic as this is really just an overwritten
        //undo / redo method.

        someDrawing.remove(someFigure);
        assertFalse(someDrawing.getChildren().contains(someFigure));
        
        assertNotNull(someFigure);
                
    }
    
    @Test
    public void redo() {
        
        System.out.println("Redo");
        
        //Can't call super.redo() from here, but it would appear that
        //all it does is so check for whether the action is redoable or not.
        
        undo();
        
        someDrawing.add(someFigure);
        assertTrue(someDrawing.getChildren().contains(someFigure));
                
    }
}
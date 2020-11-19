/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Firefigher
 */
public class GivenMouseAction extends Stage<GivenMouseAction> {
    @ProvidedScenarioState
    BezierTool beziertool;
    @ProvidedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ProvidedScenarioState
    int xAxis = 127;
    @ProvidedScenarioState
    int yAxis = 408;
    
    DefaultDrawingEditor defaultDrawingEditor;
    Constrainer constrainer;
    Drawing drawing;
    
    
    private void setupMock(){
        //Assigning Mock objects to test variables.
        beziertool = new BezierTool(new BezierFigure());
        defaultDrawingEditor = Mockito.mock(DefaultDrawingEditor.class);
        defaultDrawingView = Mockito.mock(DefaultDrawingView.class);
        constrainer = Mockito.mock(GridConstrainer.class);
        drawing = Mockito.mock(QuadTreeDrawing.class);
        
        
        Mockito.when(defaultDrawingEditor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingEditor.findView(defaultDrawingView)).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        Mockito.when(constrainer.constrainPoint(new Point2D.Double(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        beziertool.activate(defaultDrawingEditor);
        Mockito.when(defaultDrawingView.getConstrainer()).thenReturn(constrainer);
        Mockito.when(beziertool.getDrawing()).thenReturn(drawing);
        Mockito.when(beziertool.getView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.getDrawing()).thenReturn(drawing);
        
    }
    
    public GivenMouseAction givenMouseAction() {
        
        //Setting up the variables and mock objects.
        setupMock();
        
        //Testing that variables are not null.
        assertNotNull(beziertool);
        
        assertNotNull(defaultDrawingEditor);
        assertNotNull(defaultDrawingView);
        assertNotNull(constrainer);
        assertNotNull(drawing);
        
        
        //Seting fake mouse action.
        givenMouseClicked();
        
        //Setting a fake mouse dragging.
        givenMouseDragged();
        
        
        return this;
    }
    
    
    private void givenMouseClicked() {
        beziertool.mouseClicked(getMouseEvent(xAxis, yAxis));
    }
    
    private void givenMouseDragged() {
        for (int i = 0; i < 10; i++) {
            xAxis = 137 + (i*10);
            beziertool.mouseDragged(getMouseEvent(xAxis, yAxis));
        }
    }
  
    private MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEvent.getX()).thenReturn(x);
        Mockito.when(mouseEvent.getY()).thenReturn(y);
        Mockito.when(mouseEvent.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        return mouseEvent;
    }  
}

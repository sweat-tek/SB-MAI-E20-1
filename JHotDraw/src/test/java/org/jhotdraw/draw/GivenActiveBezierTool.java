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
import java.util.LinkedHashSet;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import org.mockito.Mockito;

/**
 *
 * @author Firefigher
 */
public class GivenActiveBezierTool extends Stage<GivenActiveBezierTool> {
    @ProvidedScenarioState
    BezierTool beziertool;
    @ProvidedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ProvidedScenarioState
    int xAxis = 150;
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
        Mockito.doCallRealMethod().when(defaultDrawingView).setSelectedFigures(any(LinkedHashSet.class));
        defaultDrawingView.setSelectedFigures(new LinkedHashSet<Figure>());
        Mockito.doCallRealMethod().when(defaultDrawingView).addToSelection(any(Figure.class));
        Mockito.doCallRealMethod().when(defaultDrawingView).getSelectedFigures();
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
    
    public GivenActiveBezierTool givenActiveBezierTool() {
        
        //Setting up the variables and mock objects.
        setupMock();
        
        //Testing that variables are not null.
        assertNotNull(beziertool);
        
        assertNotNull(defaultDrawingEditor);
        assertNotNull(defaultDrawingView);
        assertNotNull(constrainer);
        assertNotNull(drawing);
        
        return self();
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;


/**
 *
 * @author Firefigher
 */
public class ThenBezierFigureIsCreated extends Stage<ThenBezierFigureIsCreated> {
    
    @ExpectedScenarioState
    BezierTool beziertool;
    @ExpectedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ExpectedScenarioState
    int xAxis;
    @ExpectedScenarioState
    int yAxis;
    
    public ThenBezierFigureIsCreated thenBezierFigureIsCreated () {
        
        //Get final figure and control that it is created 
        Set<Figure> figureSet = defaultDrawingView.getSelectedFigures();
        
        Iterator<Figure> figureIterator = defaultDrawingView.getSelectedFigures().iterator();
        BezierFigure finalFig = (BezierFigure) figureIterator.next();

        assertNotNull(beziertool);
        assertNotNull(finalFig);

        assertEquals(2, finalFig.path.size());
        
        assertEquals(xAxis -100, finalFig.getBezierPath().get(0).x[0], 0.001);
        assertEquals(yAxis, finalFig.getBezierPath().get(0).y[0], 0.001);
        
        assertEquals(xAxis, finalFig.getBezierPath().get(1).x[0], 0.001);
        assertEquals(yAxis, finalFig.getBezierPath().get(1).y[0], 0.001);
        
        return self();
    }
    
}

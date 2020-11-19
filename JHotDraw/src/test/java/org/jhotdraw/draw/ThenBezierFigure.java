/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.junit.Assert.*;


/**
 *
 * @author Firefigher
 */
public class ThenBezierFigure {
    
    @ExpectedScenarioState
    BezierTool bezierTool;
    
    @ExpectedScenarioState
    int xAxis;
    @ExpectedScenarioState
    int yAxis;
    
    public ThenBezierFigure figureCreated() {
        
        //Get final figure
        BezierFigure finalFig = bezierTool.getLastFigure();
        
        assertNotNull(finalFig);
        
        assertEquals(2, finalFig.path.size());
        
        assertEquals(xAxis -100, finalFig.getBezierPath().get(0).x[0], 0.001);
        assertEquals(yAxis, finalFig.getBezierPath().get(0).y[0], 0.001);
        
        assertEquals(xAxis, finalFig.getBezierPath().get(1).x[0], 0.001);
        assertEquals(yAxis, finalFig.getBezierPath().get(1).y[0], 0.001);
        
        return this;
    }
    
}

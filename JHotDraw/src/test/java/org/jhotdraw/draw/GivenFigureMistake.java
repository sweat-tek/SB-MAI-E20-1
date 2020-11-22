/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ryge
 */
public class GivenFigureMistake extends Stage<GivenFigureMistake> {
    
    @ProvidedScenarioState
    private Drawing testDrawing;
    private BezierFigure testFigure;
    
    
    
    @BeforeScenario
    public void start() {
        testDrawing = new DefaultDrawing();
        testFigure = new BezierFigure();
    }
    
    public GivenFigureMistake createdFigure() {
        testDrawing.add(testFigure);
        assertTrue(testDrawing.getChildren().contains(testFigure));
        return self();
    }
}
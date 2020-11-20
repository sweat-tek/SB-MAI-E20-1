/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures.behaviourTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;

import static org.junit.Assert.*;

/**
 *
 * @author oscar
 */
public class ThenEllipseIsBigger extends Stage<ThenEllipseIsBigger> {

    @ExpectedScenarioState
    private Figure ellipseFigure;

    @ExpectedScenarioState
    private double enlargedHeight;
    @ExpectedScenarioState
    private double enlargedWidth;

    @ExpectedScenarioState
    private double originalHeight;
    @ExpectedScenarioState
    private double originalWidth;

    public ThenEllipseIsBigger ellipseHasBeenEnlarged() {

        boolean heightIsBigger = this.originalHeight < this.enlargedHeight;
        assertTrue(heightIsBigger);

        boolean widthIsBigger = this.originalWidth < this.enlargedWidth;
        assertTrue(widthIsBigger);

        return this;
    }

}

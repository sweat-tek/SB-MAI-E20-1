/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures.behaviourTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author oscar
 */
public class EllipseBehaviourTest extends ScenarioTest<GivenEllipse, WhenEnlargen, ThenEllipseIsBigger> {

    @Test
    public void selectingAnEllipseAndEnlargenIt() {
        given().anEllipseFigure();
        when().enlargenSelectedEllipse();
        then().ellipseHasBeenEnlarged();
    }
}

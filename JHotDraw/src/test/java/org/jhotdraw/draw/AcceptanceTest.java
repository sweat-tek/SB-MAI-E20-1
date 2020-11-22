/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Ryge
 */
public class AcceptanceTest extends ScenarioTest<GivenFigureMistake, WhenUndoingFigure, ThenFigureRemoved> {
   
    @Test
    public void undoingAFigure() {
        given().createdFigure();
        when().undoneFigure();
        then().removedFigure();
    }
    
}

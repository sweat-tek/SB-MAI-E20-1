/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import org.jhotdraw.app.Application;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.DefaultApplicationModel;
import org.jhotdraw.app.DefaultSDIApplication;
import org.jhotdraw.app.action.AbstractViewAction;
import org.jhotdraw.app.action.UndoAction;
import org.jhotdraw.samples.svg.SVGApplicationModel;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Ryge
 */
public class WhenUndoingFigure extends Stage<WhenUndoingFigure> {
    
   
    
    @BeforeStage
    public void start() {
        
    }
    
    public WhenUndoingFigure undoneFigure() {

       return this;
    }
    
}

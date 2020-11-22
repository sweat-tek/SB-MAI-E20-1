/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAreaTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
/**
 *
 * @author askel
 */
public class GivenTextArea extends Stage<GivenTextArea> {
    
    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }
    
    
    GivenTextArea aTextArea(){
        SVGTextAreaFigure textArea = new SVGTextAreaFigure();
        editor.getActiveView().getDrawing().add(textArea);
        return this;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAreaTests;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.figures.*;
/**
 *
 * @author askel
 */
public class WhenTextAreaIsSelected extends Stage<WhenTextAreaIsSelected> {
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ProvidedScenarioState
    private SVGTextAreaFigure textArea;
    
    
    @BeforeStage
    public void before(){
        textArea = (SVGTextAreaFigure)editor.getActiveView().getDrawing().getChildren().get(0);
    }
    
    WhenTextAreaIsSelected textAreaSelected(){
        editor.getActiveView().addToSelection(textArea);
        return this;
    }
    
    WhenTextAreaIsSelected TextIsWritten(){
        textArea.setText("This is a test");
        return this;
    }
    
}

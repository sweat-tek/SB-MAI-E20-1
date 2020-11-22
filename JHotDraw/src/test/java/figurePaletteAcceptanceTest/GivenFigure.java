/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurePaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.TextArea;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.OPACITY;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;

/**
 *
 * @author Earl
 */
public class GivenFigure extends Stage<GivenFigure> {
    
    @ProvidedScenarioState
    SVGTextAreaFigure textArea;
    Double opacity;
            
    @BeforeStage
    private void before(){
        textArea = new SVGTextAreaFigure("yay for software maintenance");
    }
    
    GivenFigure aFigureWithOpacity(){
        opacity = textArea.getAttribute(OPACITY);
        
        return this;
    } 
}

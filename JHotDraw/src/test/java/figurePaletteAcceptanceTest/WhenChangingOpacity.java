/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurePaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.TextArea;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.OPACITY;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;

/**
 *
 * @author Earl
 */
public class WhenChangingOpacity extends Stage<WhenChangingOpacity> {
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    SVGTextAreaFigure textArea;
    Double opacity;
    
   
    
    WhenChangingOpacity changeOpacity(){
        Double newOpacity = 0.5;
        textArea.setAttribute(OPACITY, newOpacity);
        
        return this;
    }
    
}

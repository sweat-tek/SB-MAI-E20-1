/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAreaTests;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.Set;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author askel
 */
public class ThenTextAreaContainsText extends Stage<ThenTextAreaContainsText>{
    
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private SVGTextAreaFigure textArea;
    
    
    ThenTextAreaContainsText textAreaIsSelected(){ 
        assertTrue(editor.getActiveView().getSelectedFigures().contains(textArea)); 
        return this;
    }
    
    ThenTextAreaContainsText textAreaContainsWrittentext(){
        assertEquals(textArea.getText(), "This is a test");
        return this;
    }
}

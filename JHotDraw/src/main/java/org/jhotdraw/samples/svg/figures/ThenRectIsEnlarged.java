package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioStage;
import org.jhotdraw.draw.Figure;

import static org.junit.Assert.*;

/**
 *
 * @author DanThai
 */
public class ThenRectIsEnlarged extends Stage<ThenRectIsEnlarged>{
    
    @ExpectedScenarioState
    private Figure rectFigure;
    
    @ExpectedScenarioState
    private double enlargedHeight;
    @ExpectedScenarioState
    private double enlargedWidth;
    
    @ExpectedScenarioStage
    private double height;
    @ExpectedScenarioStage
    private double width;
    
    public ThenRectIsEnlarged rectIsEnlarged() {
        
        boolean heightHasChanged = this.height < this.enlargedHeight;
        assertTrue(heightHasChanged);
        
        boolean widthHasChanged = this.width < this.enlargedWidth;
        assertTrue(widthHasChanged);
        
        return this;
    }
        
}

package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioStage;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.Figure;

/**
 *
 * @author DanThai
 */
public class WhenEnlargen extends Stage<WhenEnlargen> {
    
    @ExpectedScenarioState
    private Figure rectFigure;
    
    @ProvidedScenarioState
    private double enlargedHeight;
    @ProvidedScenarioState
    private double enlargedWidth;
    
    @BeforeStage
    private void before() {
        this.enlargedHeight = 50;
        this.enlargedWidth = 50;
    }
    
    public WhenEnlargen selectedAndEnlarged() {
        this.rectFigure.willChange();
        
        Point2D.Double anchor = new Point2D.Double(0, 0);
        Point2D.Double lead = new Point2D.Double(this.enlargedWidth, this.enlargedHeight);
        this.rectFigure.setBounds(anchor, lead);
        
        this.rectFigure.changed();
        return this;
    }
    
}

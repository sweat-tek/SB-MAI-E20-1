package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioStage;
import org.jhotdraw.draw.*;

/**
 *
 * @author DanThai
 */
public class GivenRect extends Stage<GivenRect> {
    
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ProvidedScenarioState
    private Figure rectFigure;
    
    @ProvidedScenarioState
    private double height;
    
    @ProvidedScenarioState
    private double width;
    
    @BeforeStage
    private void before() {
        this.editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        this.editor.setActiveView(view);
        
        this.height = 10;
        this.width = 10;
    }
    
    public GivenRect aRect() {
        Figure rectFigure = new SVGRectFigure(0, 0, this.height, this.width);
        this.rectFigure = rectFigure;
        this.editor.getActiveView().getDrawing().add(rectFigure);
        this.editor.getActiveView().addToSelection(rectFigure);
        return this;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Color;
import java.util.HashMap;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.action.AttributeAction;
import org.jhotdraw.draw.action.EditorColorChooserAction;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_OPACITY;
import org.junit.Test;



/**
 *
 * @author tobia
 */
public class GivenFigure extends Stage<GivenFigure>
{
    
    @ProvidedScenarioState
    DrawingEditor editor;
    @ProvidedScenarioState
    EditorColorChooserAction colorChooserAction;
    @ProvidedScenarioState
    HashMap<AttributeKey, Object> colorMap;
    @ProvidedScenarioState
    HashMap<AttributeKey, Object> opacityMap;
    @ProvidedScenarioState
    AttributeAction opacityChooserAction;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
        colorChooserAction = new EditorColorChooserAction(editor, AttributeKeys.FILL_COLOR);
        opacityChooserAction = new AttributeAction(editor, FILL_OPACITY, null);
        
    }

    GivenFigure aSelectedFigure() {
        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        return this;
    }
    
    GivenFigure multipleSelectedFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f3);
        return this;
    }

    GivenFigure aSelectedColor(Color c)
    {
        
        colorMap = new HashMap<>();
        colorMap.put(AttributeKeys.FILL_COLOR, c);
        return this;
    }
    
    GivenFigure aSelectedOpacity(double d)
    {
        opacityMap = new HashMap<>();
        opacityMap.put(SVGAttributeKeys.OPACITY, d);
        return this;
    }
    
    
    
    
}

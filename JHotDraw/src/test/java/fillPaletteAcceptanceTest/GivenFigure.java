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
    AttributeAction editorColorChooserAction;
    @ProvidedScenarioState
    HashMap<AttributeKey, Object> attr;
    

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
        editorColorChooserAction = new EditorColorChooserAction(editor, AttributeKeys.FILL_COLOR);
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

    GivenFigure aSelectedColorBlue()
    {
        attr = new HashMap<>();
        attr.put(AttributeKeys.FILL_COLOR, Color.blue);
        return this;
    }
    
    GivenFigure aSelectedColorRed()
    {
        attr = new HashMap<>();
        attr.put(AttributeKeys.FILL_COLOR, Color.red);
        return this;
    }
    
    
    
    
}

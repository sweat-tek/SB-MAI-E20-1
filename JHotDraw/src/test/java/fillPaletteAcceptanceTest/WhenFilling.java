/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.HashMap;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.AttributeAction;
import org.jhotdraw.draw.action.EditorColorChooserAction;
import org.junit.Test;

/**
 *
 * @author tobia
 */
public class WhenFilling extends Stage<WhenFilling>
{
    @ExpectedScenarioState
    EditorColorChooserAction colorChooserAction;
    @ExpectedScenarioState
    DrawingEditor editor;
    @ExpectedScenarioState
    HashMap<AttributeKey, Object> colorMap;
    @ExpectedScenarioState
    HashMap<AttributeKey, Object> opacityMap;
    @ExpectedScenarioState
    AttributeAction opacityChooserAction;
            
    
    
    WhenFilling fillingColor()
    {
        colorChooserAction.applyAttributesTo(colorMap, editor.getActiveView().getSelectedFigures()); 
        return this;
    }
    
    WhenFilling fillingOpacity()
    {
        opacityChooserAction.applyAttributesTo(opacityMap, editor.getActiveView().getSelectedFigures()); 
        return this;
    }
    
}

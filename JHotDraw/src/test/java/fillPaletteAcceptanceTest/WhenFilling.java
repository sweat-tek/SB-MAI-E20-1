/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.util.HashMap;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.AttributeAction;
import org.junit.Test;

/**
 *
 * @author tobia
 */
public class WhenFilling extends Stage<WhenFilling>
{
    @ExpectedScenarioState
    AttributeAction editorColorChooserAction;
    @ExpectedScenarioState
    DrawingEditor editor;
    @ExpectedScenarioState
    HashMap<AttributeKey, Object> attr;
            
    
    
    WhenFilling fillingColor()
    {
        editorColorChooserAction.applyAttributesTo(attr, editor.getActiveView().getSelectedFigures()); 
        return this;
    }
    
}

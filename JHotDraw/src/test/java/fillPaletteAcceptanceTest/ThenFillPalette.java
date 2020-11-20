/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Color;
import java.util.HashMap;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.action.AttributeAction;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tobia
 */
public class ThenFillPalette extends Stage<ThenFillPalette>
{
    @ExpectedScenarioState
    AttributeAction editorColorChooserAction;
    @ExpectedScenarioState
    DrawingEditor editor;
    @ExpectedScenarioState
    HashMap<AttributeKey, Object> attr;
    
    ThenFillPalette figuresShouldBeColoredBlue()
    {
        for (Figure f : editor.getActiveView().getSelectedFigures())
        {
            Assert.assertEquals(f.getAttribute(AttributeKeys.FILL_COLOR), Color.blue);
        }
        
        return this;
    }
    
    ThenFillPalette figuresShouldBeColoredRed()
    {
        for (Figure f : editor.getActiveView().getSelectedFigures())
        {
            Assert.assertEquals(f.getAttribute(AttributeKeys.FILL_COLOR), Color.red);
        }
        
        return this;
    }
}

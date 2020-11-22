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
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author tobia
 */
public class ThenFillPalette extends Stage<ThenFillPalette>
{
    @ExpectedScenarioState
    DrawingEditor editor;
    
    ThenFillPalette figuresShouldBeColored(Color c)
    {
        for (Figure f : editor.getActiveView().getSelectedFigures())
        {
            Assert.assertEquals(f.getAttribute(AttributeKeys.FILL_COLOR), c);
        }
        
        return this;
    }
    
    ThenFillPalette figuresShouldHaveOpacity(double d)
    {
        for (Figure f : editor.getActiveView().getSelectedFigures())
        {
            assertEquals(f.getAttribute(SVGAttributeKeys.FILL_OPACITY), d, 0.01);
        }
        
        return this;
    }
}

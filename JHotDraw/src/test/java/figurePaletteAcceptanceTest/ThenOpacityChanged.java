/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurePaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.OPACITY;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import org.junit.Assert;

/**
 *
 * @author Earl
 */
public class ThenOpacityChanged extends Stage<ThenOpacityChanged> {

    @ExpectedScenarioState
    SVGTextAreaFigure textArea;
    Double opacity;

    ThenOpacityChanged opacityShouldBeChanged() {
        Double newOpacity = textArea.getAttribute(OPACITY);

        Assert.assertNotEquals(opacity, newOpacity);
        
        return this;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurePaletteAcceptanceTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Earl
 */
public class FigurePaletteJGivenTest extends ScenarioTest<GivenFigure, WhenChangingOpacity, ThenOpacityChanged> {
    
    @Test
    public void opacityIsChanged(){
        given().aFigureWithOpacity();
        when().changeOpacity();
        then().opacityShouldBeChanged();
    }
}

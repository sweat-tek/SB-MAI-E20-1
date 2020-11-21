/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillPaletteAcceptanceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
/**
 *
 * @author tobia
 */
public class FillPaletteJGivenTest extends ScenarioTest<GivenFigure,WhenFilling,ThenFillPalette>
{
    @Test
    public void figureIsColoredBlue() {
        given().aSelectedFigure().and().aSelectedColorBlue();
        when().fillingColor();
        then().figuresShouldBeColoredBlue();
    }
    
    @Test
    public void figureIsColoredRed() {
        given().aSelectedFigure().and().aSelectedColorRed();
        when().fillingColor();
        then().figuresShouldBeColoredRed();
    }
    
    @Test
    public void figureIsColoredRedGroup() {
        given().multipleSelectedFigures().and().aSelectedColorRed();
        when().fillingColor();
        then().figuresShouldBeColoredRed();
    }
    
    @Test
    public void figureIsColoredBlueGroup() {
        given().multipleSelectedFigures().and().aSelectedColorBlue();
        when().fillingColor();
        then().figuresShouldBeColoredBlue();
    }
    
    @Test
    public void figureIsTransparent() {
        given().aSelectedFigure().and().aSelectedOpacityTransparent();
        when().fillingOpacity();
        then().figuresShouldBeTransparent();
    }
    
    @Test
    public void figureIsTransparentGroup() {
        given().multipleSelectedFigures().and().aSelectedOpacityTransparent();
        when().fillingOpacity();
        then().figuresShouldBeTransparent();
    }
    
}

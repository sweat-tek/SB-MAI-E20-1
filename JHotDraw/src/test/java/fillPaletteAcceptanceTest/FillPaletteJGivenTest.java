/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillPaletteAcceptanceTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Color;
import org.junit.Test;
/**
 *
 * @author tobia
 */
public class FillPaletteJGivenTest extends ScenarioTest<GivenFigure,WhenFilling,ThenFillPalette>
{
    @Test
    public void figureIsColoredBlue() {
        given().aSelectedFigure()
                .and().aSelectedColor(Color.blue);
        
        when().fillingColor();
        
        then().figuresShouldBeColored(Color.blue);
    }
    
    @Test
    public void figureIsColoredRed() {
        given().aSelectedFigure().and().aSelectedColor(Color.red);
        when().fillingColor();
        then().figuresShouldBeColored(Color.red);
    }
    
    @Test
    public void figureIsColoredRedGroup() {
        given().multipleSelectedFigures().and().aSelectedColor(Color.red);
        when().fillingColor();
        then().figuresShouldBeColored(Color.red);
    }
    
    @Test
    public void figureIsColoredBlueGroup() {
        given().multipleSelectedFigures().and().aSelectedColor(Color.blue);
        when().fillingColor();
        then().figuresShouldBeColored(Color.blue);
    }
    
    @Test
    public void figureIsOpaque() {
        given().aSelectedFigure()
                .and().aSelectedOpacity(1);
        
        when().fillingOpacity();
        
        then().figuresShouldHaveOpacity(1);
    }
    
    @Test
    public void figureIsTransparentGroup() {
        given().multipleSelectedFigures().and().aSelectedOpacity(0);
        when().fillingOpacity();
        then().figuresShouldHaveOpacity(0);
    }
    
    @Test
    public void testUserStory() {
        given().multipleSelectedFigures()
                .and().aSelectedOpacity(0)
                .and().aSelectedColor(Color.red);
        
        when().fillingOpacity()
                .and().fillingColor();
        
        then().figuresShouldHaveOpacity(0)
                .and().figuresShouldBeColored(Color.red);
    }
    
}

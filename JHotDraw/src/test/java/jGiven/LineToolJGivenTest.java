package jGiven;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class LineToolJGivenTest
        extends ScenarioTest<GivenLineTool, WhenSettingAttributeOnPathFigureAndDrawingFigure, ThenLineIsDrawn> {

    @Test
    public void lineShouldBeDrawn(){
        given().anSvgPathFigure().and().graphics().and().strokeColor();
        when().settingAttributeOnPathFigure().and().drawingFigureOnGraphics();
        then().lineIsDrawnInCorrectColor();
    }
}
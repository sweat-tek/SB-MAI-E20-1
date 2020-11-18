package jGiven;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.awt.Color;
import java.awt.Graphics2D;

public class WhenSettingAttributeOnPathFigureAndDrawingFigure extends Stage<WhenSettingAttributeOnPathFigureAndDrawingFigure> {

    @ExpectedScenarioState
    SVGPathFigure svgPathFigure;
    @ExpectedScenarioState
    Graphics2D g;

    public WhenSettingAttributeOnPathFigureAndDrawingFigure settingAttributeOnPathFigure() {
        svgPathFigure.setAttribute(AttributeKeys.FILL_COLOR, Color.MAGENTA);
        return self();
    }

    public WhenSettingAttributeOnPathFigureAndDrawingFigure drawingFigureOnGraphics() {
        svgPathFigure.draw(g);
        return self();
    }
}

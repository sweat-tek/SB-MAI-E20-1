package jGiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class GivenLineTool extends Stage<GivenLineTool> {

    @ProvidedScenarioState
    SVGPathFigure svgPathFigure;
    @ProvidedScenarioState
    Graphics2D g;

    public GivenLineTool anSvgPathFigure() {
        svgPathFigure = new SVGPathFigure();
        return self();
    }

    public GivenLineTool graphics(){
        g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics();
        return self();
    }
}

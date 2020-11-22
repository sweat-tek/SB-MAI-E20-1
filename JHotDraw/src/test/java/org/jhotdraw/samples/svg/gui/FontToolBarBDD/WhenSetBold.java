package org.jhotdraw.samples.svg.gui.FontToolBarBDD;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class WhenSetBold extends Stage<WhenSetBold> {

    @ExpectedScenarioState
    private DefaultDrawingView view;

    public WhenSetBold set_bold() {
        SVGTextFigure textFig = (SVGTextFigure) view.getSelectedFigures().iterator().next();
        textFig.setAttribute(SVGAttributeKeys.FONT_BOLD, true);
        return self();
    }
}
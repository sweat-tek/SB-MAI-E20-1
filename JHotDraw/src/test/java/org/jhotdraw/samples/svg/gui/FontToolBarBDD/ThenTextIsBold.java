package org.jhotdraw.samples.svg.gui.FontToolBarBDD;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Assert;

public class ThenTextIsBold extends Stage<ThenTextIsBold> {

    @ExpectedScenarioState
    private DefaultDrawingView view;

    public ThenTextIsBold text_is_bold() {
        SVGTextFigure textFig = (SVGTextFigure) view.getSelectedFigures().iterator().next();
        Assert.assertEquals("test text", textFig.getText());
        Assert.assertEquals(true, textFig.getAttribute(SVGAttributeKeys.FONT_BOLD));
        return self();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures.behaviourTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

/**
 *
 * @author oscar
 */
public class WhenEnlargen extends Stage<WhenEnlargen> {

    @ExpectedScenarioState
    private Figure ellipseFigure;

    @ProvidedScenarioState
    private double enlargedHeight;
    @ProvidedScenarioState
    private double enlargedWidth;

    @BeforeStage
    private void before() {
        this.enlargedHeight = 100;
        this.enlargedWidth = 100;
    }

    WhenEnlargen enlargenSelectedEllipse() {

        this.ellipseFigure.willChange();

        Point2D.Double anchor = new Point2D.Double(0, 0);
        Point2D.Double lead = new Point2D.Double(this.enlargedWidth, this.enlargedHeight);
        this.ellipseFigure.setBounds(anchor, lead);

        this.ellipseFigure.changed();
        return this;
    }

}

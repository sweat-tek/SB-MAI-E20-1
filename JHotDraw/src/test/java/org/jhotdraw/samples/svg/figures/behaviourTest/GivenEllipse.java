/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures.behaviourTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

/**
 *
 * @author oscar
 */
public class GivenEllipse extends Stage<GivenEllipse> {

    @ProvidedScenarioState
    private DrawingEditor editor;
    @ProvidedScenarioState
    private Figure ellipseFigure;

    @ProvidedScenarioState
    private double originalHeight;
    @ProvidedScenarioState
    private double originalWidth;

    @BeforeStage
    //Setup a drawing and initial height and width for ellipses
    private void before() {
        this.editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        this.editor.setActiveView(view);

        this.originalHeight = 10;
        this.originalWidth = 10;
    }

    //Creates and ellipse and adds it to the drawing, as well as current selection
    public GivenEllipse anEllipseFigure() {
        Figure ellipseFigure = new SVGEllipseFigure(0, 0, this.originalWidth, this.originalWidth);
        this.ellipseFigure = ellipseFigure;
        this.editor.getActiveView().getDrawing().add(ellipseFigure);
        this.editor.getActiveView().addToSelection(ellipseFigure);
        return this;
    }
}

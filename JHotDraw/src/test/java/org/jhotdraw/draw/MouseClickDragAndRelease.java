/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Firefigher
 */
public class MouseClickDragAndRelease extends Stage<MouseClickDragAndRelease> {

    @ExpectedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ExpectedScenarioState
    BezierTool beziertool;
    @ExpectedScenarioState
    int xAxis;
    @ExpectedScenarioState
    int yAxis;

    public MouseClickDragAndRelease mouseClickDragAndRelease() {
        //Seting fake mouse action.
        givenMouseClicked();

        //Setting a fake mouse dragging.
        givenMouseDragged();
        System.out.println(beziertool.createdFigure);
        beziertool.mouseReleased(getMouseEvent(yAxis + 8, yAxis));
        
        return self();
    }

    private void givenMouseClicked() {
        beziertool.mousePressed(getMouseEvent(xAxis, yAxis));
    }

    private void givenMouseDragged() {
        for (int i = 0; i < 10; i++) {
            xAxis = 137 + (i * 10);
            beziertool.mouseDragged(getMouseEvent(xAxis, yAxis));
        }
        
    }

    private MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEvent.getX()).thenReturn(x);
        Mockito.when(mouseEvent.getY()).thenReturn(y);
        Mockito.when(mouseEvent.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));

        return mouseEvent;
    }
}

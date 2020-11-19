/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
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
public class WhenMouseReleased {

    @ExpectedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ExpectedScenarioState
    BezierTool bezierTool;

    @ExpectedScenarioState
    int yAxis;
    @ExpectedScenarioState
    int xAxis;

    public WhenMouseReleased mouseReleased() {
        
        bezierTool.mouseReleased(getMouseEvent(yAxis + 8, yAxis));
        return this;
    }

    
    public MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEvent.getX()).thenReturn(x);
        Mockito.when(mouseEvent.getY()).thenReturn(y);
        Mockito.when(mouseEvent.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        return mouseEvent;
    }
}

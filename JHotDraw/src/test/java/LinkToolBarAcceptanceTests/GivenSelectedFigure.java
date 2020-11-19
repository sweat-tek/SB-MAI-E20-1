package LinkToolBarAcceptanceTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;

public class GivenSelectedFigure extends Stage<GivenSelectedFigure> {

    @ProvidedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ProvidedScenarioState
    int xAxis = 250;
    @ProvidedScenarioState
    int yAxis = 150;
    @ProvidedScenarioState
    BezierTool bezierTool;
    @ProvidedScenarioState
    BezierFigure bezierFigure;
    @ProvidedScenarioState
    DefaultDrawingEditor defaultDrawingEditor;

    GridConstrainer gridConstrainer;
    Drawing drawing;

    public GivenSelectedFigure selectedFigure() {
        mockSetup();

        assertNotNull(bezierTool);
        assertNotNull(defaultDrawingEditor);
        assertNotNull(defaultDrawingView);
        assertNotNull(gridConstrainer);
        assertNotNull(drawing);

        bezierTool.mousePressed(getMouseEvent(xAxis, yAxis));

        // Adding the mocked created figure to the selected figure in the drawing view
        bezierFigure = (BezierFigure) bezierTool.getCreatedFigure();
        defaultDrawingView.addToSelection(bezierFigure);

        return this;
    }

    public void mockSetup() {
        bezierTool = new BezierTool(new BezierFigure());
        defaultDrawingEditor = spy(new DefaultDrawingEditor());
        defaultDrawingView = spy(new DefaultDrawingView());
        gridConstrainer = Mockito.mock(GridConstrainer.class);
        drawing = Mockito.mock(QuadTreeDrawing.class);

        Mockito.when(defaultDrawingEditor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingEditor.findView(defaultDrawingView)).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        Mockito.when(gridConstrainer.constrainPoint(new Point2D.Double(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        bezierTool.activate(defaultDrawingEditor);
        Mockito.when(defaultDrawingView.getConstrainer()).thenReturn(gridConstrainer);
        Mockito.when(bezierTool.getDrawing()).thenReturn(drawing);
        Mockito.when(bezierTool.getView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.getDrawing()).thenReturn(drawing);

    }

    public MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEventMock = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEventMock.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEventMock.getX()).thenReturn(x);
        Mockito.when(mouseEventMock.getY()).thenReturn(y);
        Mockito.when(mouseEventMock.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        return mouseEventMock;
    }
}

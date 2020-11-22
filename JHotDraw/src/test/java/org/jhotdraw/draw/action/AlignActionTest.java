package org.jhotdraw.draw.action;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import junit.framework.TestCase;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.LineFigure;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

public class AlignActionTest {
    private ArrayList<LineFigure> selectedFigures;
    private LineFigure lineFigure1;
    private LineFigure lineFigure2;

    @Before
    public void setup() {
        /* DRAW 2 LINES */
        selectedFigures = new ArrayList<>();
        // Line 1
        lineFigure1 = new LineFigure();
        lineFigure1.setBounds(new Point2D.Double(1, 1), new Point2D.Double(2,2));
        selectedFigures.add(lineFigure1);
        // Line 2
        lineFigure2 = new LineFigure();
        lineFigure2.setBounds(new Point2D.Double(3, 3), new Point2D.Double(5,5));
        selectedFigures.add(lineFigure2);
    }

    @Test
    public void testGetSelectionBounds() {
        /* SETUP WITH MOCKITO */
        AlignAction.East alignEastAction = mock(AlignAction.East.class);
        DrawingView drawingView = mock(DrawingView.class);
        Mockito.when(drawingView.getSelectedFigures()).thenReturn(new HashSet<>(selectedFigures));
        Mockito.when(alignEastAction.getView()).thenReturn(drawingView);
        doCallRealMethod().when(alignEastAction).getSelectionBounds();

        /* ACTUAL TEST */
        Rectangle2D.Double expectedBounds = lineFigure1.getBounds();
        expectedBounds.add(lineFigure2.getBounds());

        Rectangle2D.Double actualBounds = alignEastAction.getSelectionBounds();
        assertTrue(actualBounds.x == expectedBounds.x &&
                actualBounds.y == expectedBounds.y &&
                actualBounds.width == expectedBounds.width &&
                actualBounds.height == expectedBounds.height
        );
    }
}
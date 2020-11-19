/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jhotdraw.draw.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 *
 * @author ngram
 */
public class AlignActionTest {

    ArrayList<LineFigure> selectedFigures;
    LineFigure lineFigure1;
    LineFigure lineFigure2;
    Rectangle2D.Double selectionBounds;
    
    @Before
    public void setUp() {
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

        /* MAKE SELECTION THAT INCLUDES LINES */
        selectionBounds = new Rectangle2D.Double(0, 0, 10, 10);
    }
    
    @Test
    public void testAlignFiguresEast() {
        /* SETUP WITH MOCKITO */
        AlignAction.East alignEastAction = mock(AlignAction.East.class);
        DrawingView drawingView = mock(DrawingView.class);
        when(drawingView.getSelectedFigures()).thenReturn(new HashSet<>(selectedFigures));
        when(alignEastAction.getView()).thenReturn(drawingView);
        doCallRealMethod().when(alignEastAction).alignFigures(anyCollection(), any(Rectangle2D.Double.class));
        doCallRealMethod().when(alignEastAction).getTranslate(any(Rectangle2D.Double.class), any(Rectangle2D.Double.class));

        /* ACTUAL TEST */
        // Before
        for (LineFigure selectedFigure : selectedFigures) {
            System.out.println(selectedFigure.getBounds());
        }

        // Calling the method
        // When calling alignFigures, we expected the x values to increase as they move towards EAST
        alignEastAction.alignFigures(selectedFigures, selectionBounds);

        // After
        for (LineFigure selectedFigure : selectedFigures) {
            System.out.println(selectedFigure.getBounds());
            assertTrue(selectionBounds.x + selectionBounds.width - selectedFigure.getBounds().width == selectedFigure.getBounds().x);
        }
    }

    @Test
    public void testGetSelectionBounds() {
        /* SETUP WITH MOCKITO */
        AlignAction.East alignEastAction = mock(AlignAction.East.class);
        DrawingView drawingView = mock(DrawingView.class);
        when(drawingView.getSelectedFigures()).thenReturn(new HashSet<>(selectedFigures));
        when(alignEastAction.getView()).thenReturn(drawingView);
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

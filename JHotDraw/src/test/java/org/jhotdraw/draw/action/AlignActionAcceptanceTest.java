/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.*;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 *
 * @author ngram
 */
public class AlignActionAcceptanceTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutCome> {

    @Test
    public void testAlignFiguresEast() {
        given().two_line_figures()
                .and()
                .a_selection();
        when().align_east();
        then().expect_line_figures_to_be_aligned_east();
    }

    @Test
    public void testAlignFiguresNorth() {
        given().two_line_figures()
                .and()
                .a_selection();
        when().align_north();
        then().expect_line_figures_to_be_aligned_north();
    }
}


class GivenSomeState extends Stage<GivenSomeState> {
    @ProvidedScenarioState
    ArrayList<LineFigure> selectedFigures;
    @ProvidedScenarioState
    Rectangle2D.Double selectionBounds;

    public GivenSomeState two_line_figures() {
        selectedFigures = new ArrayList<>();
        // Line 1
        LineFigure lineFigure1 = new LineFigure();
        lineFigure1.setBounds(new Point2D.Double(1, 1), new Point2D.Double(2,2));
        selectedFigures.add(lineFigure1);
        // Line 2
        LineFigure lineFigure2 = new LineFigure();
        lineFigure2.setBounds(new Point2D.Double(3, 3), new Point2D.Double(5,5));
        selectedFigures.add(lineFigure2);

        return self();
    }

    public GivenSomeState a_selection() {
        // Selection
        selectionBounds = new Rectangle2D.Double(0, 0, 10, 10);

        return self();
    }
}

class WhenSomeAction extends Stage<WhenSomeAction> {
    @ExpectedScenarioState
    ArrayList<LineFigure> selectedFigures;
    @ExpectedScenarioState
    Rectangle2D.Double selectionBounds;

    public WhenSomeAction align_east() {
        /* SETUP WITH MOCKITO */
        AlignAction.East alignEastAction = mock(AlignAction.East.class);
        DrawingView drawingView = mock(DrawingView.class);
        Mockito.when(drawingView.getSelectedFigures()).thenReturn(new HashSet<>(selectedFigures));
        Mockito.when(alignEastAction.getView()).thenReturn(drawingView);
        doCallRealMethod().when(alignEastAction).alignFigures(anyCollection(), any(Rectangle2D.Double.class));
        doCallRealMethod().when(alignEastAction).getTranslate(any(Rectangle2D.Double.class), any(Rectangle2D.Double.class));

        for (LineFigure selectedFigure : selectedFigures) {
            System.out.println(selectedFigure.getBounds());
        }
        alignEastAction.alignFigures(selectedFigures, selectionBounds);

        return self();
    }

    public WhenSomeAction align_north() {
        /* SETUP WITH MOCKITO */
        AlignAction.North alignNorthAction = mock(AlignAction.North.class);
        DrawingView drawingView = mock(DrawingView.class);
        Mockito.when(drawingView.getSelectedFigures()).thenReturn(new HashSet<>(selectedFigures));
        Mockito.when(alignNorthAction.getView()).thenReturn(drawingView);
        doCallRealMethod().when(alignNorthAction).alignFigures(anyCollection(), any(Rectangle2D.Double.class));
        doCallRealMethod().when(alignNorthAction).getTranslate(any(Rectangle2D.Double.class), any(Rectangle2D.Double.class));

        /* TEST METHOD */
        alignNorthAction.alignFigures(selectedFigures, selectionBounds);

        return self();
    }
}

class ThenSomeOutCome extends Stage<ThenSomeOutCome> {
    @ExpectedScenarioState
    ArrayList<LineFigure> selectedFigures;
    @ExpectedScenarioState
    Rectangle2D.Double selectionBounds;

    public ThenSomeOutCome expect_line_figures_to_be_aligned_east() {

        for (LineFigure selectedFigure : selectedFigures) {
            if (!(selectionBounds.x + selectionBounds.width - selectedFigure.getBounds().width == selectedFigure.getBounds().x)) {
                fail("Not aligned");
            }
        }
        return self();
    }

    public ThenSomeOutCome expect_line_figures_to_be_aligned_north() {

        for (LineFigure selectedFigure : selectedFigures) {
            if (!(selectionBounds.y == selectedFigure.getBounds().y)) {
                fail("Not aligned");
            }
        }
        return self();
    }

}
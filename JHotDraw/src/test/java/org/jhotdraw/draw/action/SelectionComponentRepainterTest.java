package org.jhotdraw.draw.action;

import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.FigureSelectionListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SelectionComponentRepainterTest {

    private SelectionComponentRepainter testSelectionComponentRepainter;

    @Before
    public void setUp() {
        DrawingEditor drawingEditor = new DefaultDrawingEditor();
        testSelectionComponentRepainter = new SelectionComponentRepainter(drawingEditor, null);
    }

    @Test
    public void addListeners() {
        // Could have extended this to include the case where the view has a drawing set.
        DefaultDrawingView view = new DefaultDrawingView();
        Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(testSelectionComponentRepainter));
        Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(testSelectionComponentRepainter));
        testSelectionComponentRepainter.addListeners(view);
        Assert.assertTrue(Arrays.asList(view.getPropertyChangeListeners()).contains(testSelectionComponentRepainter));
        Assert.assertTrue(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(testSelectionComponentRepainter));
    }

    @Test
    public void removeListeners() {
        DefaultDrawingView view = new DefaultDrawingView();
        testSelectionComponentRepainter.removeListeners(view);
        Assert.assertFalse(Arrays.asList(view.getPropertyChangeListeners()).contains(testSelectionComponentRepainter));
        Assert.assertFalse(Arrays.asList(view.getListeners(FigureSelectionListener.class)).contains(testSelectionComponentRepainter));
    }

    @Test
    public void dispose() {
        testSelectionComponentRepainter.dispose();
        Assert.assertNull(testSelectionComponentRepainter.getComponent());
    }

    @Test
    public void selectionChanged() {
    }
}
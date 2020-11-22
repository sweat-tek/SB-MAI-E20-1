/**
 * @(#)SelectionComponentRepainter.java 1.0  23.05.2008
 * <p>
 * Copyright (c) 2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 * <p>
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
 */
package org.jhotdraw.draw.action;

import org.jhotdraw.draw.*;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Calls repaint on components, which show attributes of the drawing editor
 * and of its views based on the current selection.
 *
 * @author Werner Randelshofer
 *  @version 1.0 23.05.2008 Created.
 */
public class SelectionComponentRepainter extends AbstractComponentRepainter
        implements PropertyChangeListener, FigureSelectionListener {

    private DrawingEditor editor;

    public SelectionComponentRepainter(DrawingEditor editor, JComponent component) {
        super(component);
        this.editor = editor;
        if (editor != null) {
            if (editor.getActiveView() != null) {
                DrawingView view = editor.getActiveView();
                view.addPropertyChangeListener(this);
                view.addFigureSelectionListener(this);
                if (view.getDrawing() != null) {
                    view.getDrawing().addFigureListener(this);
                }
            }
            editor.addPropertyChangeListener(this);
        }
    }

    @Override
    protected void addListeners(DrawingView view) {
        if (view == null) return;
        view.addPropertyChangeListener(this);
        view.addFigureSelectionListener(this);
        if (view.getDrawing() == null) return;
        view.getDrawing().addFigureListener(this);
    }

    @Override
    protected void removeListeners(DrawingView view) {
        if (view == null) return;
        view.removePropertyChangeListener(this);
        view.removeFigureSelectionListener(this);
        if (view.getDrawing() == null) return;
        view.getDrawing().removeFigureListener(this);
    }

    @Override
    public void dispose() {
        if (editor != null) {
            if (editor.getActiveView() != null) {
                DrawingView view = editor.getActiveView();
                view.removePropertyChangeListener(this);
                view.removeFigureSelectionListener(this);
                if (view.getDrawing() != null) {
                    view.getDrawing().removeFigureListener(this);
                }
            }
            editor.removePropertyChangeListener(this);
            editor = null;
        }
        setComponent(null);
    }

    public void selectionChanged(FigureSelectionEvent evt) {
        getComponent().repaint();
    }
}


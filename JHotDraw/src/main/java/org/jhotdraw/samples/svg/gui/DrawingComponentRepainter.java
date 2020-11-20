/**
 * @(#)DrawingComponentRepainter.java 1.0  2008-06-08
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
package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.FigureEvent;
import org.jhotdraw.draw.action.AbstractComponentRepainter;

import javax.swing.*;
import java.beans.PropertyChangeListener;

/**
 * Calls repaint on components, which show attributes of a drawing object
 * on the current view of the editor.
 *
 * @author Werner Randelshofer
 * @version 1.0 23.05.2008 Created.
 */
public class DrawingComponentRepainter extends AbstractComponentRepainter
        implements PropertyChangeListener {

    private DrawingEditor editor;
    private JComponent component;

    public DrawingComponentRepainter(DrawingEditor editor, JComponent component) {
        super(component);
        this.editor = editor;
        if (editor != null) {
            if (editor.getActiveView() != null) {
                DrawingView view = editor.getActiveView();
                view.addPropertyChangeListener(this);
                if (view.getDrawing() != null) {
                    view.getDrawing().addFigureListener(this);
                }
            }

            editor.addPropertyChangeListener(this);
        }
    }

    @Override
    public void attributeChanged(FigureEvent evt) {
        component.repaint();
    }

    @Override
    public void addListeners(final DrawingView view) {
        if (view != null) {
            view.addPropertyChangeListener(this);
            if (view.getDrawing() != null) {
                view.getDrawing().addFigureListener(this);
            }
        }
    }

    @Override
    public void removeListeners(final DrawingView view) {
        if (view != null) {
            view.removePropertyChangeListener(this);
            if (view.getDrawing() != null) {
                view.getDrawing().removeFigureListener(this);
            }
        }
    }

    @Override
    public void dispose() {
        if (editor != null) {
            if (editor.getActiveView() != null) {
                DrawingView view = editor.getActiveView();
                view.removePropertyChangeListener(this);
                if (view.getDrawing() != null) {
                    view.getDrawing().removeFigureListener(this);
                }
            }
            editor.removePropertyChangeListener(this);
            editor = null;
        }
        component = null;
    }
}


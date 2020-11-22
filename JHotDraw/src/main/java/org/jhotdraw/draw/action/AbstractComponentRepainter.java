package org.jhotdraw.draw.action;

import org.jhotdraw.draw.*;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public abstract class AbstractComponentRepainter extends FigureAdapter {

    private JComponent component;

    protected AbstractComponentRepainter(final JComponent component) {
        this.component = component;
    }

    @Override
    public void attributeChanged(FigureEvent evt) {
        component.repaint();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        if (name.equals(DrawingEditor.ACTIVE_VIEW_PROPERTY)) {
            handleActiveViewPropertyChange(evt);
        } else if (name.equals(DrawingView.DRAWING_PROPERTY)) {
            handleDrawingPropertyChange(evt);
        } else {
            component.repaint();
        }
    }

    private void handleActiveViewPropertyChange(PropertyChangeEvent evt) {
        DrawingView view = (DrawingView) evt.getOldValue();
        removeListeners(view);
        view = (DrawingView) evt.getNewValue();
        addListeners(view);
        component.repaint();
    }

    private void handleDrawingPropertyChange(PropertyChangeEvent evt) {
        Drawing drawing = (Drawing) evt.getOldValue();
        if (drawing != null) {
            drawing.removeFigureListener(this);
        }
        drawing = (Drawing) evt.getNewValue();
        if (drawing != null) {
            drawing.addFigureListener(this);
        }
        component.repaint();
    }

    public void setComponent(final JComponent component) {
        this.component = component;
    }

    protected JComponent getComponent() {
        return component;
    }

    protected abstract void addListeners(DrawingView view);

    protected abstract void removeListeners(DrawingView view);

    public abstract void dispose();
}

/*
 * @(#)AlignAction.java  2.1  2008-02-27
 *
 * Copyright (c) 1996-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.draw.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.TransformEdit;
import org.jhotdraw.undo.CompositeEdit;
import java.awt.geom.*;
import java.util.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Aligns the selected figures.
 *
 * XXX - Fire edit events
 *
 * @author  Werner Randelshofer
 * @version 2.1 2008-02-27 Only align figures which are transformable. 
 * <br>2.0 2006-01-15 Changed to support double precision coordinates.
 * <br>1.0 17. March 2004  Created.
 */
public abstract class AlignAction extends AbstractSelectedAction {
    
    /** Creates a new instance. */
    public AlignAction(DrawingEditor editor) {
        super(editor);
    }
    public void updateEnabledState() {
        if (getView() != null) {
            setEnabled(getView().isEnabled() &&
                    getView().getSelectionCount() > 1
                    );
        } else {
            setEnabled(false);
        }
    }
    @FeatureEntryPoint(JHotDrawFeatures.ALIGN_PALETTE)
    public void actionPerformed(java.awt.event.ActionEvent e) {
        CompositeEdit edit = new CompositeEdit(labels.getString("edit.align.text"));
        fireUndoableEditHappened(edit);
        alignFigures(getView().getSelectedFigures(), getSelectionBounds());
        fireUndoableEditHappened(edit);
    }
    @FeatureEntryPoint(JHotDrawFeatures.ALIGN_PALETTE)
    protected void alignFigures(Collection selectedFigures, Rectangle2D.Double selectionBounds) {
        for (Iterator i=getView().getSelectedFigures().iterator(); i.hasNext(); ) {
            Figure f = (Figure) i.next();
            if (f.isTransformable()) {
            f.willChange();
            Rectangle2D.Double figureBounds = f.getBounds();
            AffineTransform tx = new AffineTransform();
            Point2D translate = getTranslate(selectionBounds, figureBounds);
            tx.translate(translate.getX(), translate.getY());
            f.transform(tx);
            f.changed();
            fireUndoableEditHappened(new TransformEdit(f, tx));
            }
       }
    }
    protected abstract Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds);
    
    /**
     * Returns the bounds of the selected figures.
     */
    protected Rectangle2D.Double getSelectionBounds() {
        Rectangle2D.Double bounds = null;
        for (Iterator i=getView().getSelectedFigures().iterator(); i.hasNext(); ) {
            Figure f = (Figure) i.next();
            if (bounds == null) {
                bounds = f.getBounds();
            } else {
                bounds.add(f.getBounds());
            }
        }
        return bounds;
    }
    
    public static class North extends AlignAction {
        public North(DrawingEditor editor) {
            super(editor);
            labels.configureAction(this, "edit.alignNorth");
        }
        public North(DrawingEditor editor, ResourceBundleUtil labels) {
            super(editor);
            labels.configureAction(this, "edit.alignNorth");
        }
        
        @Override
        protected Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds) {
            return new Point2D.Double(0, selectionBounds.y - figureBounds.y);
        }

    }
    public static class East extends AlignAction {
        public East(DrawingEditor editor) {
            super(editor);
            labels.configureAction(this, "edit.alignEast");
        }
        public East(DrawingEditor editor, ResourceBundleUtil labels) {
            super(editor);
            labels.configureAction(this, "edit.alignEast");
        }


        @Override
        protected Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds) {
            return new Point2D.Double(selectionBounds.x + selectionBounds.width - figureBounds.x - figureBounds.width, 0);
        }
    }
    public static class West extends AlignAction {
        public West(DrawingEditor editor) {
            super(editor);
            labels.configureAction(this, "edit.alignWest");
        }
        public West(DrawingEditor editor, ResourceBundleUtil labels) {
            super(editor);
            labels.configureAction(this, "edit.alignWest");
        }

        @Override
        protected Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds) {
            return new Point2D.Double(selectionBounds.x - figureBounds.x, 0);
        }
    }
    public static class South extends AlignAction {
        public South(DrawingEditor editor) {
            super(editor);
            labels.configureAction(this, "edit.alignSouth");
        }
        public South(DrawingEditor editor, ResourceBundleUtil labels) {
            super(editor);
            labels.configureAction(this, "edit.alignSouth");
        }

        @Override
        protected Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds) {
            return new Point2D.Double(0, selectionBounds.y + selectionBounds.height - figureBounds.y - figureBounds.height);
        }
    }
    public static class Vertical extends AlignAction {
        public Vertical(DrawingEditor editor) {
            super(editor);
            labels.configureAction(this, "edit.alignVertical");
        }
        public Vertical(DrawingEditor editor, ResourceBundleUtil labels) {
            super(editor);
            labels.configureAction(this, "edit.alignVertical");
        }

        @Override
        protected Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds) {
            return new Point2D.Double(0, (selectionBounds.y + selectionBounds.height / 2) - (figureBounds.height / 2));
        }
        
    }
    public static class Horizontal extends AlignAction {
        public Horizontal(DrawingEditor editor) {
            super(editor);
            labels.configureAction(this, "edit.alignHorizontal");
        }
        public Horizontal(DrawingEditor editor, ResourceBundleUtil labels) {
            super(editor);
            labels.configureAction(this, "edit.alignHorizontal");
        }

        @Override
        protected Point2D getTranslate(Rectangle2D.Double selectionBounds, Rectangle2D.Double figureBounds) {
            return new Point2D.Double((selectionBounds.x + selectionBounds.width / 2) - (figureBounds.x - figureBounds.width / 2), 0);
        }
    }
}
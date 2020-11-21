/*
 * @(#)StrokeToolBar.java  1.2  2008-05-23
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import javax.swing.border.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.JFontChooser;

/**
 * StrokeToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.2 2008-05-23 Hide the toolbar if nothing is selected, and no
 *          creation tool is active. <br>
 *          1.1 2008-03-26 Don't draw button borders. <br>
 *          1.0 May 1, 2007 Created.
 */
public class FontToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

    /** Creates new instance. */
    public FontToolBar() {
        setName(labels.getString("font.toolbar"));
        JFontChooser.loadAllFonts();
        setDisclosureStateCount(3);
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this) {

                @Override
                public void updateVisibility() {
                    boolean newValue = editor != null && editor.getActiveView() != null
                            && (isVisibleIfCreationTool
                                    && ((editor.getTool() instanceof TextCreationTool)
                                            || editor.getTool() instanceof TextAreaCreationTool)
                                    || containsTextHolderFigure(editor.getActiveView().getSelectedFigures()));
                    component.setVisible(newValue);

                    // The following is needed to trick BoxLayout
                    if (newValue) {
                        component.setPreferredSize(null);
                    } else {
                        component.setPreferredSize(new Dimension(0, 0));
                    }

                    component.revalidate();
                }

                private boolean containsTextHolderFigure(Collection<Figure> figures) {
                    for (Figure f : figures) {
                        if (f instanceof TextHolderFigure) {
                            return true;
                        } else if (f instanceof CompositeFigure) {
                            if (containsTextHolderFigure(((CompositeFigure) f).getChildren())) {
                                return true;
                            }
                        }
                    }
                    return false;

                }
            };
        }
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.FONT_PALETTE)
	public JComponent createDisclosedComponent(int state) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(new EmptyBorder(5, 5, 5, 8));

        FontToolBarUI fontUI = new FontToolBarUI(editor, p, labels);
        if (state == 1)
            fontUI.createFontFamilyChooser(2, 2, labels.getString("attribute.font.toolTipText"));
        else
            fontUI.createFontFamilyChooser(10, 3, labels.getString("attribute.font.toolTipText"));
        fontUI.createFontSizeChooser(1, labels.getString("attribute.fontSize.toolTipText"));
        fontUI.createFontStyleChooser();
        return p;
    }

    @Override
    protected String getID() {
        return "font";
    }

    @Override
    protected int getDefaultDisclosureState() {
        return 1;
    }
}

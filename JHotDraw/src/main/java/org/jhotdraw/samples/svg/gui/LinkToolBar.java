/*
 * @(#)LinkToolBar.java  1.0  2009-04-17
 *
 * Copyright (c) 2009 by the original authors of JHotDraw
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

import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.TextUI;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.plaf.palette.*;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * LinkToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.0 2009-04-17 Created.
 */
public class LinkToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;
    private final ResourceBundleUtil labels;

    /**
     * Creates new instance.
     */
    public LinkToolBar() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
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
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }

    // Replace Method
    private class DisclosedComponentState {
        private final int state;
        private final JPanel p = new JPanel();
        private GridBagConstraints gbc;

        private final JScrollPane scrollPane = new javax.swing.JScrollPane();
        private final JAttributeTextArea<String> linkField = new JAttributeTextArea<>();

        private final JLabel targetLabel = new javax.swing.JLabel();
        private final JAttributeTextField<String> targetField = new JAttributeTextField<>();

        public DisclosedComponentState(int state) {
            this.state = state;
        }

        public void configureJPanel() {
            p.setOpaque(false);
            p.setLayout(new GridBagLayout());
            p.setBorder(new EmptyBorder(5, 5, 5, 8));
        }

        public void configureScrollPane() {
            scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.putClientProperty("JComponent.sizeVariant", "small");
            scrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"));
        }

        // Extract Function
        public void configureLinkLabel() {
            JLabel linkLabel = new javax.swing.JLabel();
            linkLabel.setUI((LabelUI) PaletteLabelUI.createUI(linkLabel));
            linkLabel.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
            linkLabel.setText(labels.getString("attribute.figureLink.text")); // NOI18N
            linkLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

            linkLabel.setLabelFor(linkField);
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.insets = new Insets(-2, 0, -2, 0);
            gbc.anchor = GridBagConstraints.SOUTHWEST;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            p.add(linkLabel, gbc);
        }

        public void configureLinkField(int columns, int rows) {
            linkField.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
            linkField.setColumns(columns);
            linkField.setLineWrap(true);
            linkField.setRows(rows);
            linkField.setWrapStyleWord(true);
            linkField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
            linkField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
            new FigureAttributeEditorHandler<>(LINK, linkField, editor, false);

            scrollPane.setViewportView(linkField);
        }

        public void configureGridBagConstraintsForScrollPane(Insets scrollPaneInsets) {
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = scrollPaneInsets;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1d;
            gbc.weighty = 1d;
            p.add(scrollPane, gbc);

        }

        public void configureTargetLabel() {
            targetLabel.setUI((LabelUI) PaletteLabelUI.createUI(targetLabel));
            targetLabel.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
            targetLabel.setText(labels.getString("attribute.figureLinkTarget.text")); // NOI18N
            //targetLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

            targetLabel.setLabelFor(targetField);
        }

        public void configureGridBagConstraintsForTargetLabel() {
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(3, 0, 0, 0);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            p.add(targetLabel, gbc);
        }

        public void configureTargetField(int columns) {
            targetField.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
            targetField.setColumns(columns);
            //targetField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
            targetField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
            targetField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
            new FigureAttributeEditorHandler<>(LINK_TARGET, targetField, editor, false);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.insets = new Insets(3, 3, 0, 0);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            p.add(targetField, gbc);
        }

        public JPanel execute() {
            assert getName().equals(labels.getString(getID() + ".toolbar")) : "NAME OF LINK TOOLBAR IS NOT CORRECT";
            configureJPanel();
            int linkFieldColumns;
            Insets scrollPaneInsets;
            int targetFieldColumns;
            p.isOpaque();

            switch (state) {
                case 1:
                    configureLinkLabel();
                    linkFieldColumns = 8;
                    scrollPaneInsets = new Insets(3, 0, 0, 0);
                    targetFieldColumns = 4;
                    break;

                case 2:
                    linkFieldColumns = 12;
                    scrollPaneInsets = new Insets(0, 0, 0, 0);
                    targetFieldColumns = 7;
                    break;

                default:
                    return null;
            }

            configureScrollPane();
            configureLinkField(linkFieldColumns, 2);
            configureGridBagConstraintsForScrollPane(scrollPaneInsets);
            configureTargetLabel();
            configureGridBagConstraintsForTargetLabel();
            configureTargetField(targetFieldColumns);
            return p;
        }
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.LINK_PALETTE)
    protected JComponent createDisclosedComponent(int state) {
        return new DisclosedComponentState(state).execute();
    }

    @Override
    protected String getID() {
        return "link";
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

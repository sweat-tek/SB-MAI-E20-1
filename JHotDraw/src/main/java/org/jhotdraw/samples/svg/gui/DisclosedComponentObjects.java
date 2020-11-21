package org.jhotdraw.samples.svg.gui;

import javax.swing.JPanel;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.util.ResourceBundleUtil;

public class DisclosedComponentObjects {

    private JPanel panel = new JPanel();
    private DrawingEditor editor;
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

    public DisclosedComponentObjects(DrawingEditor editor) {
        this.editor = editor;
    }

    public DrawingEditor getEditor() {
        return editor;
    }

    public JPanel getPanel() {
        return panel;
    }

    public ResourceBundleUtil getLabels() {
        return labels;
    }
}

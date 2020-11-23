package org.jhotdraw.samples.svg.gui.disclosed_component;

import javax.swing.JPanel;

import org.jhotdraw.draw.DrawingEditor;

public abstract class DisclosedComponent {
    protected DisclosedComponentObjects disclosedComponentObjects;
    protected int[] allowedStates;
    protected int actualState;

    public DisclosedComponent(int[] allowedStates, int actualState, DrawingEditor editor) {
        this.allowedStates = allowedStates;
        this.actualState = actualState;
        this.disclosedComponentObjects = new DisclosedComponentObjects(editor);
    }

    public abstract JPanel build();
}

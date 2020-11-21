package org.jhotdraw.samples.svg.gui;

import java.util.Arrays;

import javax.swing.JPanel;

import org.jhotdraw.draw.DrawingEditor;

public class DisclosedComponent {
    private DisclosedComponentObjects disclosedComponentObjects;
    private int[] allowedStates;
    private int actualState;

    public DisclosedComponent(int[] allowedStates, int actualState, DrawingEditor editor) {
        this.allowedStates = allowedStates;
        this.actualState = actualState;
        this.disclosedComponentObjects = new DisclosedComponentObjects(editor);
    }

    public JPanel build() {
        if (!Arrays.stream(allowedStates).anyMatch(i -> i == actualState))
            return null;
        UILib.createJPanel(disclosedComponentObjects.getPanel());

        if (actualState == 1)
            UILib.createFontFamilyChooser(disclosedComponentObjects, 2, 2);
        if (actualState == 2)
            UILib.createFontFamilyChooser(disclosedComponentObjects, 10, 3);
        UILib.createFontSizeChooser(disclosedComponentObjects, 1);
        UILib.createFontStyleChooser(disclosedComponentObjects);
        return disclosedComponentObjects.getPanel();
    }
}

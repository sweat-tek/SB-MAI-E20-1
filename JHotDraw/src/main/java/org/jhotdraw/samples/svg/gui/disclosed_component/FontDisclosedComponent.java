package org.jhotdraw.samples.svg.gui.disclosed_component;

import java.util.Arrays;

import javax.swing.JPanel;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.gui.UILib;

public class FontDisclosedComponent extends DisclosedComponent {

    public FontDisclosedComponent(int[] allowedStates, int actualState, DrawingEditor editor) {
        super(allowedStates, actualState, editor);
    }

    @Override
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

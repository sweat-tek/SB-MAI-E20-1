package org.jhotdraw.samples.svg.gui.FontToolBarUI;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.action.SelectionComponentRepainter;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.text.FontFormatter;
import org.jhotdraw.text.JavaNumberFormatter;
import org.jhotdraw.util.ResourceBundleUtil;

import java.awt.*;
import static javax.swing.SwingConstants.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.plaf.SliderUI;

public class FontUI {

    private JPanel panel;
    private DrawingEditor editor;
    private ResourceBundleUtil labels;

    public FontUI(DrawingEditor editor, JPanel panel, ResourceBundleUtil labels) {
        this.panel = panel;
        this.editor = editor;
        this.labels = labels;
    }

    public void createFontFamilyChooser(int columns, int gridWidth, String tooltipText) {
        JAttributeTextField<Font> faceField = createFontToolBarFaceField(columns, tooltipText,
                FontFormatter.createFormatterFactory());
        new FigureAttributeEditorHandler<Font>(FONT_FACE, faceField, editor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = gridWidth;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(faceField, gbc);
        AbstractButton btn = ButtonFactory.createFontButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(btn, gbc);
    }

    public void createFontSizeChooser(int columns, String tooltipText) {
        JAttributeTextField<Double> sizeField = createFontToolBarFaceField(columns, tooltipText,
                JavaNumberFormatter.createFormatterFactory(0d, 1000d, 1d));
        new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeField, editor);
        JPanel p1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = 2;
        gbc.weightx = 1f;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        p1.add(sizeField, gbc);

        JPopupButton sizePopupButton = new JPopupButton();
        JAttributeSlider sizeSlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 12);
        sizePopupButton.add(sizeSlider);
        labels.configureToolBarButton(sizePopupButton, "attribute.fontSize");
        sizePopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(sizePopupButton));
        sizePopupButton.setPopupAnchor(SOUTH_EAST);
        new SelectionComponentRepainter(editor, sizePopupButton);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(3, 0, 0, 0);
        p1.add(sizePopupButton, gbc);
        sizeSlider.setUI((SliderUI) PaletteSliderUI.createUI(sizeSlider));
        sizeSlider.setScaleFactor(1d);
        new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeSlider, editor);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(p1, gbc);
    }

    public void createFontStyleChooser() {
        AbstractButton btn = ButtonFactory.createFontStyleBoldButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "first");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(btn, gbc);
        btn = ButtonFactory.createFontStyleItalicButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "middle");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(btn, gbc);
        btn = ButtonFactory.createFontStyleUnderlineButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "last");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(btn, gbc);
    }

    private <T> JAttributeTextField<T> createFontToolBarFaceField(int columns, String tooltipText,
            AbstractFormatterFactory formatterFactory) {
        JAttributeTextField<T> faceField = new JAttributeTextField<T>();
        faceField.setColumns(columns);
        faceField.setToolTipText(tooltipText);
        faceField.setHorizontalAlignment(JAttributeTextField.RIGHT);
        faceField.putClientProperty("Palette.Component.segmentPosition", "first");
        faceField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(faceField));
        faceField.setHorizontalAlignment(JTextField.LEADING);
        faceField.setFormatterFactory(formatterFactory);
        return faceField;
    }

}

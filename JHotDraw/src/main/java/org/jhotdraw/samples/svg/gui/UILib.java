package org.jhotdraw.samples.svg.gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.action.SelectionComponentRepainter;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.samples.svg.gui.disclosed_component.DisclosedComponentObjects;
import org.jhotdraw.text.FontFormatter;
import org.jhotdraw.text.JavaNumberFormatter;

import static javax.swing.SwingConstants.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

import javax.swing.AbstractButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.plaf.SliderUI;

public class UILib {
    public static void createJPanel(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 8));
        panel.setOpaque(false);
    }

    public static void createFontFamilyChooser(DisclosedComponentObjects objects, int columns, int gridWidth) {
        JAttributeTextField<Font> faceField = createTextField(columns,
                objects.getLabels().getString("attribute.font.toolTipText"), FontFormatter.createFormatterFactory());
        new FigureAttributeEditorHandler<Font>(FONT_FACE, faceField, objects.getEditor());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = gridWidth;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        objects.getPanel().add(faceField, gbc);
        AbstractButton btn = ButtonFactory.createFontButton(objects.getEditor(), objects.getLabels());
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        objects.getPanel().add(btn, gbc);
    }

    public static void createFontSizeChooser(DisclosedComponentObjects objects, int columns) {
        JAttributeTextField<Double> sizeField = createTextField(columns,
                objects.getLabels().getString("attribute.font.toolTipText"),
                JavaNumberFormatter.createFormatterFactory(0d, 1000d, 1d));
        new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeField, objects.getEditor());
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
        objects.getLabels().configureToolBarButton(sizePopupButton, "attribute.fontSize");
        sizePopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(sizePopupButton));
        sizePopupButton.setPopupAnchor(SOUTH_EAST);
        new SelectionComponentRepainter(objects.getEditor(), sizePopupButton);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(3, 0, 0, 0);
        p1.add(sizePopupButton, gbc);
        sizeSlider.setUI((SliderUI) PaletteSliderUI.createUI(sizeSlider));
        sizeSlider.setScaleFactor(1d);
        new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeSlider, objects.getEditor());

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        objects.getPanel().add(p1, gbc);
    }

    public static void createFontStyleChooser(DisclosedComponentObjects objects) {
        AbstractButton btn = ButtonFactory.createFontStyleBoldButton(objects.getEditor(), objects.getLabels());
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "first");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        objects.getPanel().add(btn, gbc);
        btn = ButtonFactory.createFontStyleItalicButton(objects.getEditor(), objects.getLabels());
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "middle");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        objects.getPanel().add(btn, gbc);
        btn = ButtonFactory.createFontStyleUnderlineButton(objects.getEditor(), objects.getLabels());
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "last");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        objects.getPanel().add(btn, gbc);
    }

    private static <T> JAttributeTextField<T> createTextField(int columns, String tooltipText,
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

package org.jhotdraw.samples.svg.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Assert;

public class FontToolBarTest {
    private AbstractToolBar fontToolBar;

    @org.junit.Before
    public void setUp() throws Exception {
        fontToolBar = new FontToolBar();
        DrawingEditor editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        editor.add(view);
        fontToolBar.editor = editor;

    }

    @org.junit.After
    public void tearDown() throws Exception {
        fontToolBar = null;
    }

    @org.junit.Test
    public void createDisclosedComponent_With_InvalidState_Returns_Null() {
        JPanel panelWithStateMinus1 = (JPanel) fontToolBar.createDisclosedComponent(-1);
        JPanel panelWithState0 = (JPanel) fontToolBar.createDisclosedComponent(0);
        JPanel panelWithState3 = (JPanel) fontToolBar.createDisclosedComponent(3);
        JPanel panelWithState99 = (JPanel) fontToolBar.createDisclosedComponent(99);
        Assert.assertNull(panelWithStateMinus1);
        Assert.assertNull(panelWithState0);
        Assert.assertNull(panelWithState3);
        Assert.assertNull(panelWithState99);
    }

    @org.junit.Test
    public void createDisclosedComponent_With_State1_Creates_FontToolBar() {
        JPanel panel = (JPanel) fontToolBar.createDisclosedComponent(1);
        createDisclosedComponent_With_Valid_State_Creates_Panel(panel);
        createDisclosedComponent_With_Valid_State_Creates_FontFamilyChooser(panel, 2, 2);
        createDisclosedComponent_With_Valid_State_Creates_FontSizeChooser(panel, 1);
        createDisclosedComponent_With_Valid_State_Creates_FontStyleChooser(panel);
    }

    @org.junit.Test
    public void createDisclosedComponent_With_State2_Creates_FontToolBar() {
        JPanel panel = (JPanel) fontToolBar.createDisclosedComponent(2);
        createDisclosedComponent_With_Valid_State_Creates_Panel(panel);
        createDisclosedComponent_With_Valid_State_Creates_FontFamilyChooser(panel, 10, 3);
        createDisclosedComponent_With_Valid_State_Creates_FontSizeChooser(panel, 1);
        createDisclosedComponent_With_Valid_State_Creates_FontStyleChooser(panel);
    }

    private void createDisclosedComponent_With_Valid_State_Creates_Panel(JPanel panel) {
        panel_Is_Not_Opaque(panel);
        panel_Borders_Is_EmptyBorder_With_Correct_Values(panel);
        panel_Layout_Is_GridBagLayout(panel);
    }

    private void panel_Is_Not_Opaque(JPanel panel) {
        Assert.assertFalse(panel.isOpaque());
    }

    private void panel_Borders_Is_EmptyBorder_With_Correct_Values(JPanel panel) {
        EmptyBorder border = (EmptyBorder) panel.getBorder();
        Assert.assertEquals(5, border.getBorderInsets().top);
        Assert.assertEquals(5, border.getBorderInsets().left);
        Assert.assertEquals(5, border.getBorderInsets().bottom);
        Assert.assertEquals(8, border.getBorderInsets().right);
    }

    private void panel_Layout_Is_GridBagLayout(JPanel panel) {
        LayoutManager layout = panel.getLayout();
        Assert.assertSame((GridBagLayout) layout, layout);
    }

    private void createDisclosedComponent_With_Valid_State_Creates_FontFamilyChooser(JPanel panel, int columns,
            int gridWidth) {
        JAttributeTextField<Font> faceField = (JAttributeTextField<Font>) panel.getComponent(0);
        createTextField_Creates_TextField(faceField, columns);

        Component btn = panel.getComponent(1);
        Assert.assertSame((AbstractButton) btn, btn);
    }

    private void createDisclosedComponent_With_Valid_State_Creates_FontSizeChooser(JPanel panel, int columns) {
        JPanel subPanel = (JPanel) panel.getComponent(2);
        JAttributeTextField<Double> sizeField = (JAttributeTextField<Double>) subPanel.getComponent(0);
        createTextField_Creates_TextField(sizeField, columns);

        JPopupButton popBtn = (JPopupButton) subPanel.getComponent(1);
        Assert.assertEquals(4, popBtn.getPopupAnchor());
    }

    private void createDisclosedComponent_With_Valid_State_Creates_FontStyleChooser(JPanel panel) {
        JButton boldButton = (JButton) panel.getComponent(3);
        Assert.assertEquals("first", (String) boldButton.getClientProperty("Palette.Component.segmentPosition"));
        JButton italicButton = (JButton) panel.getComponent(4);
        Assert.assertEquals("middle", (String) italicButton.getClientProperty("Palette.Component.segmentPosition"));
        JButton underlineButton = (JButton) panel.getComponent(5);
        Assert.assertEquals("last", (String) underlineButton.getClientProperty("Palette.Component.segmentPosition"));
    }

    private <T> void createTextField_Creates_TextField(JAttributeTextField<T> textField, int columns) {
        Assert.assertEquals(columns, textField.getColumns());
        Assert.assertEquals(
                ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels").getString("attribute.font.toolTipText"),
                textField.getToolTipText());
        // Assert.assertEquals(JAttributeTextField.RIGHT,
        // faceField.getHorizontalAlignment());
        Assert.assertEquals("first", (String) textField.getClientProperty("Palette.Component.segmentPosition"));
    }

}

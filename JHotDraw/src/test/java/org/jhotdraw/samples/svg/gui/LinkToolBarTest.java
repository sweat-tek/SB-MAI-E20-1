package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.gui.JAttributeTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static org.junit.Assert.*;

public class LinkToolBarTest {

    private LinkToolBar linkToolBarUnderTest;

    @org.junit.Before
    public void setUp() throws Exception {
        linkToolBarUnderTest = new LinkToolBar();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        linkToolBarUnderTest = null;
    }

    public void testGeneralThingsInJPanel(JPanel jpanelUnderTest) {

        assertFalse(jpanelUnderTest.isOpaque()); // jpanel should not be opaque

        // Below the border of the jpanel is tested
        EmptyBorder jpanelEmptyBorder = (EmptyBorder)jpanelUnderTest.getBorder(); // The border should be a emptyBorder. If it isn't this will throw an error
        assertEquals(5,jpanelEmptyBorder.getBorderInsets().top); // The top insets should be 5
        assertEquals(5,jpanelEmptyBorder.getBorderInsets().left); // The left insets should be 5
        assertEquals(5,jpanelEmptyBorder.getBorderInsets().bottom); // The bottom insets should be 5
        assertEquals(8,jpanelEmptyBorder.getBorderInsets().right); // The right insets should be 5

        // Below the layout of the jpanel is tested
        GridBagLayout jpanelGridBagLayout = (GridBagLayout) jpanelUnderTest.getLayout(); // The layout should be a jpanelGridBaglayout. If it isn't this will throw an error
    }

    public void testSpecificThingsToState1(JPanel jPanelUnderTest) {
        // Below all the four components is tested to check if they contain the correct attributes
        Component[] components = jPanelUnderTest.getComponents();

        assertEquals(4, components.length); // There should be four components in the jpanel

        for(Component component : components) {
            // Is the target field correctly configured?
            if (component instanceof JAttributeTextField) {
                JAttributeTextField<String> textField = (JAttributeTextField<String>) component;
                if (textField.getToolTipText().equals("attribute.figureLinkTarget.toolTipText")) { // It is the target field
                    assertEquals(8, textField.getColumns()); // we expect 8 columns in case 1 with the target field
                } else if (textField.getToolTipText().equals("attribute.figureLink.toolTipText")) { // it is the link field
                    assertEquals(4, textField.getColumns()); // we expect 4 columns in case 1 with the link field
                }
            }
        }
    }

    public void testSpecificThingsToState2(JPanel jPanelUnderTest) {
        // Below all the four components is tested to check if they contain the correct attributes
        Component[] components = jPanelUnderTest.getComponents();

        assertEquals(3, components.length); // There should be three components in the jpanel in case 2

        for(Component component : components) {
            // Is the target field correctly configured?
            if (component instanceof JAttributeTextField) {
                JAttributeTextField<String> textField = (JAttributeTextField<String>) component;
                if (textField.getToolTipText().equals("attribute.figureLinkTarget.toolTipText")) { // It is the target field
                    assertEquals(12, textField.getColumns()); // we expect 8 columns in case 1 with the target field
                } else if (textField.getToolTipText().equals("attribute.figureLink.toolTipText")) { // it is the link field
                    assertEquals(7, textField.getColumns()); // we expect 4 columns in case 1 with the link field
                }
            }
        }
    }

    @org.junit.Test
    public void createDisclosedComponentTest1() {
        JPanel jpanelUnderTest = (JPanel) linkToolBarUnderTest.createDisclosedComponent(1);
        testGeneralThingsInJPanel(jpanelUnderTest);
        testSpecificThingsToState1(jpanelUnderTest);
    }

    @org.junit.Test
    public void createDisclosedComponentTestState2() {
        JPanel jpanelUnderTest = (JPanel) linkToolBarUnderTest.createDisclosedComponent(2);
        testGeneralThingsInJPanel(jpanelUnderTest);
        testSpecificThingsToState2(jpanelUnderTest);
    }

    @org.junit.Test
    public void createDisclosedComponentTestStateDefault() {
        JPanel jpanelUnderTest = (JPanel) linkToolBarUnderTest.createDisclosedComponent(0);
        assertNull(jpanelUnderTest);
        jpanelUnderTest = (JPanel) linkToolBarUnderTest.createDisclosedComponent(5);
        assertNull(jpanelUnderTest);
        jpanelUnderTest = (JPanel) linkToolBarUnderTest.createDisclosedComponent(-5);
        assertNull(jpanelUnderTest);
    }
}
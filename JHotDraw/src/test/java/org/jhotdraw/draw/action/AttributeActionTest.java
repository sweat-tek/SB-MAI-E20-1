/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.gui.AttributeEditor;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_OPACITY;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import sun.awt.image.PixelConverter;

/**
 *
 * @author tobia
 */
public class AttributeActionTest
{
    
    AttributeAction editorColorChooserAction;
    DefaultDrawingEditor editor;
    AttributeAction opacityChooserAction;
    
    public AttributeActionTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        //Instantiating the EditorColorChooserAction class
        editor = new DefaultDrawingEditor();
        //It needs a view
        DrawingView drawingView = new DefaultDrawingView();
        //The view needs a drawing
        Drawing drawing = new DefaultDrawing();
        drawingView.setDrawing(drawing);

        //Applying the active view
        editor.setActiveView(drawingView);
        
        //Instantiate the 2 Choosers
        opacityChooserAction = new AttributeAction(editor, FILL_OPACITY, null);
        editorColorChooserAction = new AttributeAction(editor, AttributeKeys.FILL_COLOR,null);

    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of applyAttributesTo method, of class AttributeAction.
     */
    @Test
    public void testApplyAttributesToBlueTest()
    {
        //Imitating choosing a color form the colorChooser
        HashMap<AttributeKey, Object> colorMap = new HashMap<>();
        colorMap.put(AttributeKeys.FILL_COLOR, Color.blue);

        //create and select figures
        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        
        
        //apply the color attribute
        editorColorChooserAction.applyAttributesTo(colorMap, editor.getActiveView().getSelectedFigures()); 
        
        //Test that the figure has the new color
        assertEquals(f1.getAttribute(AttributeKeys.FILL_COLOR), Color.blue);
        
    }
    
        /**
     * Test of applyAttributesTo method, of class AttributeAction.
     */
    @Test
    public void testApplyAttributesToRedTest()
    {
        //Imitating choosing a color form the colorChooser
        HashMap<AttributeKey, Object> colorMap = new HashMap<>();
        colorMap.put(AttributeKeys.FILL_COLOR, Color.red);

        //create and select figures
        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);

        //apply the color attribute
        editorColorChooserAction.applyAttributesTo(colorMap, editor.getActiveView().getSelectedFigures()); 
        
        //Test that the figure has the new color
        assertEquals(f1.getAttribute(AttributeKeys.FILL_COLOR), Color.red);
        
    }
    
            /**
     * Test of applyAttributesTo method, of class AttributeAction.
     */
    @Test
    public void testApplyAttributesToFalseRedTest()
    {
        //Imitating choosing a color form the colorChooser
        HashMap<AttributeKey, Object> colorMap = new HashMap<>();
        colorMap.put(AttributeKeys.FILL_COLOR, Color.red);

        //create and select figures
        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);

        //apply the color attribute
        editorColorChooserAction.applyAttributesTo(colorMap, editor.getActiveView().getSelectedFigures()); 
        
        //Test that the figure is not still also green somehow
        assertNotEquals(f1.getAttribute(AttributeKeys.FILL_COLOR), Color.green);        
    }
    
            /**
     * Test of applyAttributesTo method, of class AttributeAction.
     */
    @Test
    public void testApplyAttributesToGroup()
    {
        //Imitating choosing a color form the colorChooser
        HashMap<AttributeKey, Object> colorMap = new HashMap<>();
        colorMap.put(AttributeKeys.FILL_COLOR, Color.red);

        //create and select figures
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f3);

        //apply the color attribute
        editorColorChooserAction.applyAttributesTo(colorMap, editor.getActiveView().getSelectedFigures()); 
        //Test that all the figures are now red
        assertEquals(f1.getAttribute(AttributeKeys.FILL_COLOR), Color.red);    
        assertEquals(f2.getAttribute(AttributeKeys.FILL_COLOR), Color.red); 
        assertEquals(f3.getAttribute(AttributeKeys.FILL_COLOR), Color.red); 
    }
    
    @Test
    public void testApplyAttributeOpacity()
    {
        HashMap<AttributeKey, Object> opacityMap = new HashMap<>();
        opacityMap.put(SVGAttributeKeys.OPACITY, 0.5d);
        
        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        
        opacityChooserAction.applyAttributesTo(opacityMap, editor.getActiveView().getSelectedFigures());
         
        assertEquals(f1.getAttribute(SVGAttributeKeys.OPACITY), 0.5, 0.001);
    }
    
    public void testCheckOpacityWithNoChange()
    {
        HashMap<AttributeKey, Object> opacityMap = new HashMap<>();
        opacityMap.put(SVGAttributeKeys.OPACITY, 0.5d);
        
        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        
        opacityChooserAction.applyAttributesTo(opacityMap, editor.getActiveView().getSelectedFigures());
         
        assertEquals(f1.getAttribute(SVGAttributeKeys.OPACITY), 0.5, 0.1);
    }
    
}

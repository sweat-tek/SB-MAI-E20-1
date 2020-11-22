/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import javax.swing.JComponent;
import org.jhotdraw.draw.DrawingEditor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Earl
 */
public class FigureToolBarTest {
    
    FigureToolBar toolbar;
            
    public FigureToolBarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Creating a figure toolbar, which has the functionality we want to test
        toolbar = new FigureToolBar();
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of createDisclosedComponent method, of class FigureToolBar.
     */
    @Test
    public void testCreateDisclosedComponent() {
        //Picking one of 2 states for the method parameter
        int state = 1;
        
        //Creating a JComponent based on the state
        JComponent jComponent1 = toolbar.createDisclosedComponent(state);
        
        //Picking the other state
        state = 2;
        
        //Creating a component based on this state
        JComponent jComponent2 = toolbar.createDisclosedComponent(state);
        
        //Test whether the method correctly creates different JComponents based on the state parameter
        assertNotEquals(jComponent1, jComponent2);
    }

    
    
}

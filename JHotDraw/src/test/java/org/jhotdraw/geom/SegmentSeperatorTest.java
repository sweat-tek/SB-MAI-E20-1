/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.geom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Firefigher
 */
public class SegmentSeperatorTest {
    
    
    public SegmentSeperatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lineToOrQuadto method, of class SegmentSeperator.
     */
    
    @Test
    public void testLineToOrQuadto() {
        float[] coords = {297.0f, 413.0f,0f,0f,0f};
        BezierPath.Node current = new BezierPath.Node(670.0, 433.4);
        int numCoords = 0;
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.lineToOrQuadto(coords, current, numCoords, type);
        assertEquals(1, instance.getType());  
    } 
    /**
     * Test of quadtoOrCubicto method, of class SegmentSeperator.
     */
    
    @Test
    public void testQuadtoOrCubicto() {
        float[] coords = {297.0f, 413.0f,0f,0f,0f};;
        BezierPath.Node current = new BezierPath.Node(1109.3999999999999, 633.6);
        BezierPath.Node previous = new BezierPath.Node(1092.7, 674.8);;
        int numCoords = 0;
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.quadtoOrCubicto(coords, current, previous, numCoords, type);
        System.out.println("type: " + instance.getType());
        assertEquals(2, instance.getType());
    }
}

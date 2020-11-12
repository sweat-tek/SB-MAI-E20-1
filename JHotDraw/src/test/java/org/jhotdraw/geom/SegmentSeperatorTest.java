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
    public void testLineToOrQuadto_4args_1() {
        System.out.println("lineToOrQuadto");
        float[] coords = {297.0f, 413.0f,0f,0f,0f};
        BezierPath.Node current = new BezierPath.Node(670.0, 433.4);
        int numCoords = 0;
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.lineToOrQuadto(coords, current, numCoords, type);
        //System.out.println(instance.getType());
        assertEquals(1, instance.getType());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } 
    /**
     * Test of quadtoOrCubicto method, of class SegmentSeperator.
     */
    
    @Test
    public void testQuadtoOrCubicto_5args_1() {
        System.out.println("quadtoOrCubicto");
        float[] coords = {297.0f, 413.0f,0f,0f,0f};;
        BezierPath.Node current = new BezierPath.Node(1109.3999999999999, 633.6);
        BezierPath.Node previous = new BezierPath.Node(1092.7, 674.8);;
        int numCoords = 0;
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.quadtoOrCubicto(coords, current, previous, numCoords, type);
        System.out.println("type: " + instance.getType());
        assertEquals(2, instance.getType());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of lineToOrQuadto method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testLineToOrQuadto_4args_2() {
        System.out.println("lineToOrQuadto");
        double[] coords = null;
        BezierPath.Node current = null;
        int numCoords = 0;
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.lineToOrQuadto(coords, current, numCoords, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
    /**
     * Test of quadtoOrCubicto method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testQuadtoOrCubicto_5args_2() {
        System.out.println("quadtoOrCubicto");
        double[] coords = null;
        BezierPath.Node current = null;
        BezierPath.Node previous = null;
        int numCoords = 0;
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.quadtoOrCubicto(coords, current, previous, numCoords, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getNumCoords method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testGetNumCoords() {
        System.out.println("getNumCoords");
        SegmentSeperator instance = new SegmentSeperator();
        int expResult = 0;
        int result = instance.getNumCoords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of setNumCoords method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testSetNumCoords() {
        System.out.println("setNumCoords");
        int numCoords = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.setNumCoords(numCoords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getType method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testGetType() {
        System.out.println("getType");
        SegmentSeperator instance = new SegmentSeperator();
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of setType method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 0;
        SegmentSeperator instance = new SegmentSeperator();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getFloatCoords method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testGetFloatCoords() {
        System.out.println("getFloatCoords");
        SegmentSeperator instance = new SegmentSeperator();
        float[] expResult = null;
        float[] result = instance.getFloatCoords();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of setFloatCoords method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testSetFloatCoords() {
        System.out.println("setFloatCoords");
        float[] floatCoords = null;
        SegmentSeperator instance = new SegmentSeperator();
        instance.setFloatCoords(floatCoords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getDoubleCoords method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testGetDoubleCoords() {
        System.out.println("getDoubleCoords");
        SegmentSeperator instance = new SegmentSeperator();
        double[] expResult = null;
        double[] result = instance.getDoubleCoords();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of setDoubleCoords method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testSetDoubleCoords() {
        System.out.println("setDoubleCoords");
        double[] doubleCoords = null;
        SegmentSeperator instance = new SegmentSeperator();
        instance.setDoubleCoords(doubleCoords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getWindingRule method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testGetWindingRule() {
        System.out.println("getWindingRule");
        SegmentSeperator instance = new SegmentSeperator();
        int expResult = 0;
        int result = instance.getWindingRule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of isDone method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testIsDone() {
        System.out.println("isDone");
        SegmentSeperator instance = new SegmentSeperator();
        boolean expResult = false;
        boolean result = instance.isDone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of next method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testNext() {
        System.out.println("next");
        SegmentSeperator instance = new SegmentSeperator();
        instance.next();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of currentSegment method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testCurrentSegment_floatArr() {
        System.out.println("currentSegment");
        float[] coords = null;
        SegmentSeperator instance = new SegmentSeperator();
        int expResult = 0;
        int result = instance.currentSegment(coords);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of currentSegment method, of class SegmentSeperator.
     */
    /*
    @Test
    public void testCurrentSegment_doubleArr() {
        System.out.println("currentSegment");
        double[] coords = null;
        SegmentSeperator instance = new SegmentSeperator();
        int expResult = 0;
        int result = instance.currentSegment(coords);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}

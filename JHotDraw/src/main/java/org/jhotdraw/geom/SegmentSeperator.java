package org.jhotdraw.geom;

import java.awt.geom.PathIterator;
import static java.awt.geom.PathIterator.SEG_CUBICTO;
import static java.awt.geom.PathIterator.SEG_LINETO;
import static java.awt.geom.PathIterator.SEG_QUADTO;

/**
 *
 * @author Firefigher
 */
public class SegmentSeperator implements PathIterator {
    float[] floatCoords;
    double[] doubleCoords;
    int numCoords;
    int type;
    

    public SegmentSeperator() {
    }
    
    public void lineToOrQuadto(float[] coords, BezierPath.Node current, int numCoords, int type) {
        if ((current.mask & BezierPath.C1_MASK) == 0) {
                        numCoords = 1;
                        type = SEG_LINETO;
                        coords[0] = (float) current.x[0];
                        coords[1] = (float) current.y[0];
                    } else {
                        numCoords = 2;
                        type = SEG_QUADTO;
                        coords[0] = (float) current.x[1];
                        coords[1] = (float) current.y[1];
                        coords[2] = (float) current.x[0];
                        coords[3] = (float) current.y[0];
                    }
        this.numCoords = numCoords;
        this.type = type;
        this.floatCoords = coords;
    }
    
    public void quadtoOrCubicto(float[] coords, BezierPath.Node current, BezierPath.Node previous, int numCoords, int type) {
        
        
        if ((current.mask & BezierPath.C1_MASK) == 0) {
                        numCoords = 2;
                        type = SEG_QUADTO;
                        coords[0] = (float) previous.x[2];
                        coords[1] = (float) previous.y[2];
                        coords[2] = (float) current.x[0];
                        coords[3] = (float) current.y[0];
                    } else {
                        numCoords = 3;
                        type = SEG_CUBICTO;
                        coords[0] = (float) previous.x[2];
                        coords[1] = (float) previous.y[2];
                        coords[2] = (float) current.x[1];
                        coords[3] = (float) current.y[1];
                        coords[4] = (float) current.x[0];
                        coords[5] = (float) current.y[0];
                    }
        this.numCoords = numCoords;
        this.type = type;
        this.floatCoords = coords;
    }

    
    public void lineToOrQuadto(double[] coords, BezierPath.Node current, int numCoords, int type) {
        if ((current.mask & BezierPath.C1_MASK) == 0) {
                        numCoords = 1;
                        type = SEG_LINETO;
                        coords[0] = (float) current.x[0];
                        coords[1] = (float) current.y[0];
                    } else {
                        numCoords = 2;
                        type = SEG_QUADTO;
                        coords[0] = (float) current.x[1];
                        coords[1] = (float) current.y[1];
                        coords[2] = (float) current.x[0];
                        coords[3] = (float) current.y[0];
                    }
        this.numCoords = numCoords;
        this.type = type;
        this.doubleCoords = coords;
    }
    
    public void quadtoOrCubicto(double[] coords, BezierPath.Node current, BezierPath.Node previous, int numCoords, int type) {
        
        
        if ((current.mask & BezierPath.C1_MASK) == 0) {
                        numCoords = 2;
                        type = SEG_QUADTO;
                        coords[0] = (float) previous.x[2];
                        coords[1] = (float) previous.y[2];
                        coords[2] = (float) current.x[0];
                        coords[3] = (float) current.y[0];
                    } else {
                        numCoords = 3;
                        type = SEG_CUBICTO;
                        coords[0] = (float) previous.x[2];
                        coords[1] = (float) previous.y[2];
                        coords[2] = (float) current.x[1];
                        coords[3] = (float) current.y[1];
                        coords[4] = (float) current.x[0];
                        coords[5] = (float) current.y[0];
                    }
        this.numCoords = numCoords;
        this.type = type;
        this.doubleCoords = coords;
    }
    
    
    
    
    
    public int getNumCoords() {
        return numCoords;
    }

    public void setNumCoords(int numCoords) {
        this.numCoords = numCoords;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public float[] getFloatCoords() {
        return floatCoords;
    }

    public void setFloatCoords(float[] floatCoords) {
        this.floatCoords = floatCoords;
    }

    public double[] getDoubleCoords() {
        return doubleCoords;
    }

    public void setDoubleCoords(double[] doubleCoords) {
        this.doubleCoords = doubleCoords;
    }

    @Override
    public int getWindingRule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int currentSegment(float[] coords) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int currentSegment(double[] coords) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

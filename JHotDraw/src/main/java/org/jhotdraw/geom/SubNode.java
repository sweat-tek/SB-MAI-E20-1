package org.jhotdraw.geom;

import java.awt.geom.Point2D;

/**
 *
 * @author Firefigher
 */
public class SubNode {

    private int mask;
    private double x;
    private double y;
    private Point2D.Double c0;
    
    private SubNode(NodeBuilder builder){
        this.mask = builder.mask;
        this.x = builder.x;
        this.y = builder.y;
        this.c0 = builder.c0;
    }

    
    //Private Constructor
    private SubNode() {
        
    }

    public int getMask() {
        return mask;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public static class NodeBuilder {
        private int mask;
        private double x;
        private double y;
        private Point2D.Double c0;

        // Builder method for mask.
        public NodeBuilder withMask(int mask) {
            this.mask = mask;
            return this;
        }
        
        // Builder method for the x coordinate
        public NodeBuilder withX(double x){
            this.x = x;
            return this;
        }
        
        //Builder method for the Y coordinate
        public NodeBuilder withY(double y) {
            this.y = y;
            return this;
        }
        
        public NodeBuilder withC0(Point2D.Double c0){
            this.c0 = c0;
            return this;
        }
        
        public SubNode build() {
            SubNode subnode = new SubNode();
            subnode.mask = this.mask;
            subnode.x = this.x;
            subnode.y = this.y;
            subnode.c0 = this.c0;
            return subnode;
        }
    }
}


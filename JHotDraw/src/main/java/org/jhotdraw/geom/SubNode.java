package org.jhotdraw.geom;

/**
 *
 * @author Firefigher
 */
public class SubNode {

    private int mask;
    private double x;
    private double y;
    
    private SubNode(NodeBuilder builder){
        this.mask = builder.mask;
        this.x = builder.x;
        this.y = builder.y;
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
        
        public SubNode build() {
            SubNode subnode = new SubNode();
            subnode.mask = this.mask;
            subnode.x = this.x;
            subnode.y = this.y;
            return subnode;
        }
    }
}


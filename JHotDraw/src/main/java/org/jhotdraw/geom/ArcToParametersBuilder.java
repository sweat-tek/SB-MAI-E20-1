package org.jhotdraw.geom;

public class ArcToParametersBuilder {
    private double rx;
    private double ry;
    private double xAxisRotation;
    private boolean largeArcFlag;
    private boolean sweepFlag;
    private double x;
    private double y;

    public ArcToParametersBuilder setRx(double rx) {
        this.rx = rx;
        return this;
    }

    public ArcToParametersBuilder setRy(double ry) {
        this.ry = ry;
        return this;
    }

    public ArcToParametersBuilder setxAxisRotation(double xAxisRotation) {
        this.xAxisRotation = xAxisRotation;
        return this;
    }

    public ArcToParametersBuilder setLargeArcFlag(boolean largeArcFlag) {
        this.largeArcFlag = largeArcFlag;
        return this;
    }

    public ArcToParametersBuilder setSweepFlag(boolean sweepFlag) {
        this.sweepFlag = sweepFlag;
        return this;
    }

    public ArcToParametersBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public ArcToParametersBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public BezierPath.ArcToParameters createArcToParameters() {
        return new BezierPath.ArcToParameters(rx, ry, xAxisRotation, largeArcFlag, sweepFlag, x, y);
    }
}
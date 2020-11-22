/*
 * @(#)SVGTextArea.java  2.1.1  2009-03-29
 *
 * Copyright (c) 1996-2009 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.figures;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.util.*;
import org.jhotdraw.app.JHotDrawFeatures;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.*;
import org.jhotdraw.geom.*;

/**
 * SVGTextArea.
 *
 * @author Werner Randelshofer
 * @version 2.1.1 2009-03-29 Two consecutive tab-characters in text caused
 * ArrayIndexOutOfBoundsException.
 * <br>2.1 2008-05-31 Added method getPreferredTextSize.
 * <br>2.0.1 Rectangle returned by getDrawingArea needs to be cloned.
 * <br>2.0 2007-04-14 Adapted for new AttributeKeys.TRANSFORM support.
 * <br>1.0 December 9, 2006 Created.
 */
public class SVGTextAreaFigure extends SVGAttributedFigure
        implements SVGFigure, TextHolderFigure {

    private Rectangle2D.Double bounds = new Rectangle2D.Double();
    private boolean editable = true;
    private final static BasicStroke dashes = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{4f, 4f}, 0f);
    /**
     * This is a cached value to improve the performance of method isTextOverflow();
     */
    private Boolean isTextOverflow;
    /**
     * This is used to perform faster drawing and hit testing.
     */
    private transient Rectangle2D.Double cachedDrawingArea;
    private transient Shape cachedTextShape;

    /** Creates a new instance. */
    public SVGTextAreaFigure() {
        this("Text");
    }

    @FeatureEntryPoint(JHotDrawFeatures.TEXT_AREA_TOOL)
    public SVGTextAreaFigure(String text) {
        setText(text);
        SVGAttributeKeys.setDefaults(this);
    }
    // DRAWING

    @Override
    protected void drawText(java.awt.Graphics2D g) {
    }

    protected void drawFill(Graphics2D g) {
        g.fill(getTextShape());
        g.draw(new Rectangle2D.Double(getBounds().x, getBounds().y, getPreferredTextSize(changingDepth).width, getPreferredTextSize(changingDepth).height));
    }

    @FeatureEntryPoint(JHotDrawFeatures.TEXT_AREA_TOOL)
    protected void drawStroke(Graphics2D g) {
        g.draw(getTextShape());
    }
    // SHAPE AND BOUNDS

    public Rectangle2D.Double getBounds() {
        return (Rectangle2D.Double) bounds.clone();
    }

    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    public boolean contains(Point2D.Double p) {
        if (TRANSFORM.get(this) != null) {
            try {
                p = (Point2D.Double) TRANSFORM.get(this).inverseTransform(p, new Point2D.Double());
            } catch (NoninvertibleTransformException ex) {
                ex.printStackTrace();
            }
        }

        Rectangle2D r = getTextShape().getBounds2D();
        return r.isEmpty() ? getBounds().contains(p) : r.contains(p);
    }

    private Shape getTextShape() {
        if (cachedTextShape == null) {
            GeneralPath shape;
            cachedTextShape = shape = new GeneralPath();
            if (getText() != null || isEditable()) {

                Font font = getFont();
                boolean isUnderlined = FONT_UNDERLINE.get(this);
                Insets2D.Double insets = getInsets();
                Rectangle2D.Double textRect = new Rectangle2D.Double(
                        bounds.x + insets.left,
                        bounds.y + insets.top,
                        bounds.width - insets.left - insets.right,
                        bounds.height - insets.top - insets.bottom);
                float leftMargin = (float) textRect.x;
                float rightMargin = (float) Math.max(leftMargin + 1, textRect.x + textRect.width);
                float verticalPos = (float) textRect.y;
                float maxVerticalPos = (float) (textRect.y + textRect.height);
                if (leftMargin < rightMargin) {
                    float tabWidth = (float) (getTabSize() * font.getStringBounds("m", getFontRenderContext()).getWidth());
                    float[] tabStops = new float[(int) (textRect.width / tabWidth)];
                    for (int i = 0; i < tabStops.length; i++) {
                        tabStops[i] = (float) (textRect.x + (int) (tabWidth * (i + 1)));
                    }

                    if (getText() != null) {
                        String[] paragraphs = getText().split("\n");//Strings.split(getText(), '\n');
                        for (int i = 0; i < paragraphs.length; i++) {
                            if (paragraphs[i].length() == 0) {
                                paragraphs[i] = " ";
                            }
                            AttributedString as = new AttributedString(paragraphs[i]);
                            as.addAttribute(TextAttribute.FONT, font);
                            if (isUnderlined) {
                                as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
                            }
                            int tabCount = paragraphs[i].split("\t").length - 1;
                            Rectangle2D.Double paragraphBounds = new Paragraph(
                                    shape, as.getIterator(),
                                    verticalPos, maxVerticalPos, leftMargin, rightMargin, tabStops, tabCount, getFontRenderContext()).getParagraph();
                            verticalPos = (float) (paragraphBounds.y + paragraphBounds.height);
                            if (verticalPos > textRect.y + textRect.height) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return cachedTextShape;
    }

    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        bounds.x = Math.min(anchor.x, lead.x);
        bounds.y = Math.min(anchor.y, lead.y);
        bounds.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        bounds.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
        invalidate();
    }

    /**
     * Transforms the figure.
     *
     * @param tx the transformation.
     */
    public void transform(AffineTransform tx) {
        if (TRANSFORM.get(this) != null ||
                (tx.getType() &
                (AffineTransform.TYPE_TRANSLATION /*| AffineTransform.TYPE_MASK_SCALE*/)) !=
                tx.getType()) {
            if (TRANSFORM.get(this) == null) {
                TRANSFORM.basicSet(this, (AffineTransform) tx.clone());
            } else {
                AffineTransform t = TRANSFORM.getClone(this);
                t.preConcatenate(tx);
                TRANSFORM.basicSet(this, t);
            }
        } else {
            Point2D.Double anchor = getStartPoint();
            Point2D.Double lead = getEndPoint();
            setBounds(
                    (Point2D.Double) tx.transform(anchor, anchor),
                    (Point2D.Double) tx.transform(lead, lead));
            super.gradient(tx);
        }
        invalidate();
    }

    public void restoreTransformTo(Object geometry) {
        Object[] restoreData = (Object[]) geometry;
        bounds = (Rectangle2D.Double) ((Rectangle2D.Double) restoreData[0]).clone();
        TRANSFORM.basicSetClone(this, (AffineTransform) restoreData[1]);
        FILL_GRADIENT.basicSetClone(this, (Gradient) restoreData[2]);
        STROKE_GRADIENT.basicSetClone(this, (Gradient) restoreData[3]);
        invalidate();
    }

    public Object getTransformRestoreData() {
        return new Object[]{
                    bounds.clone(),
                    TRANSFORM.getClone(this),
                    FILL_GRADIENT.getClone(this),
                    STROKE_GRADIENT.getClone(this),};
    }
// ATTRIBUTES

    public String getText() {
        return (String) getAttribute(TEXT);
    }

    public int getTextColumns() {
        return (getText() == null) ? 4 : Math.max(getText().length(), 4);
    }

    public <T> void setAttribute(AttributeKey<T> key, T newValue) {
        if (key.equals(SVGAttributeKeys.TRANSFORM) ||
                key.equals(SVGAttributeKeys.FONT_FACE) ||
                key.equals(SVGAttributeKeys.FONT_BOLD) ||
                key.equals(SVGAttributeKeys.FONT_ITALIC) ||
                key.equals(SVGAttributeKeys.FONT_SIZE) ||
                key.equals(SVGAttributeKeys.STROKE_WIDTH) ||
                key.equals(SVGAttributeKeys.STROKE_COLOR) ||
                key.equals(SVGAttributeKeys.STROKE_GRADIENT)) {
            invalidate();
        }
        super.setAttribute(key, newValue);
    }

    /**
     * Sets the text shown by the text figure.
     */
    public void setText(String newText) {
        TEXT.set(this, newText);
    }

    /**
     * Returns the insets used to draw text.
     */
    public Insets2D.Double getInsets() {
        double sw = (STROKE_COLOR.get(this) == null) ? 0 : Math.ceil(STROKE_WIDTH.get(this) / 2);
        Insets2D.Double insets = new Insets2D.Double(0, 0, 0, 0);
        return new Insets2D.Double(insets.top + sw, insets.left + sw, insets.bottom + sw, insets.right + sw);
    }

    public double getBaseline() {
        return getFont().getLineMetrics(getText(), getFontRenderContext()).getAscent() + getInsets().top;
    }

    public int getTabSize() {
        return 8;
    }

    public TextHolderFigure getLabelFor() {
        return this;
    }

    public Font getFont() {
        return SVGAttributeKeys.getFont(this);
    }

    public Color getTextColor() {
        return FILL_COLOR.get(this);
    //   return TEXT_COLOR.get(this);
    }

    public Color getFillColor() {
        return FILL_COLOR.get(this).equals(Color.white) ? Color.black : Color.WHITE;
    //  return FILL_COLOR.get(this);
    }


    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean b) {
        this.editable = b;
    }

    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();

        switch (detailLevel % 2) {
            case -1: // Mouse hover handles
                handles.add(new BoundsOutlineHandle(this, false, true));
                break;
            case 0:
                ResizeHandleKit.addResizeHandles(this, handles);
                handles.add(new FontSizeHandle(this));
                handles.add(new TextOverflowHandle(this));
                handles.add(new LinkHandle(this));
                break;
            case 1:
                TransformHandleKit.addTransformHandles(this, handles);
                break;
            default:
                break;
        }
        return handles;
    }

    /**
     * Returns a specialized tool for the given coordinate.
     * <p>Returns null, if no specialized tool is available.
     */
    public Tool getTool(Point2D.Double p) {
        if (isEditable() && contains(p)) {
            TextAreaEditingTool tool = new TextAreaEditingTool(this);
            return tool;
        }
        return null;
    }
// CONNECTING

    public boolean canConnect() {
        return false; // SVG does not support connecting
    }

    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return null; // SVG does not support connectors
    }

    public Connector findCompatibleConnector(Connector c, boolean isStartConnector) {
        return null; // SVG does not support connectors
    }
// COMPOSITE FIGURES
// CLONING
// EVENT HANDLING

    /**
     * Gets the text shown by the text figure.
     */
    public boolean isEmpty() {
        return getText() == null || getText().length() == 0;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        cachedDrawingArea = null;
        cachedTextShape = null;
        isTextOverflow = null;
    }

    public boolean isTextOverflow() {
        if (isTextOverflow == null) {
            Insets2D.Double insets = getInsets();
            isTextOverflow = getPreferredTextSize(getBounds().width - insets.left - insets.right).height > getBounds().height - insets.top - insets.bottom;
        }
        return isTextOverflow;
    }

    /**
     * Returns the preferred text size of the TextAreaFigure.
     * <p>
     * If you want to use this method to determine the bounds of the TextAreaFigure,
     * you need to add the insets of the TextAreaFigure to the size.
     * 
     * @param maxWidth the maximal width to use. Specify Double.MAX_VALUE
     * if you want the width to be unlimited.
     * @return width and height needed to lay out the text.
     */
    public Dimension2DDouble getPreferredTextSize(double maxWidth) {
        Rectangle2D.Double textRect = new Rectangle2D.Double();
        if (getText() != null) {
            Font font = getFont();
            boolean isUnderlined = FONT_UNDERLINE.get(this);
            float leftMargin = 0;
            float rightMargin = (float) maxWidth - 1;
            float verticalPos = 0;
            float maxVerticalPos = Float.MAX_VALUE;
            if (leftMargin < rightMargin) {
                float tabWidth = (float) (getTabSize() * font.getStringBounds("m", getFontRenderContext()).getWidth());
                float[] tabStops = new float[(int) (textRect.width / tabWidth)];
                for (int i = 0; i < tabStops.length; i++) {
                    tabStops[i] = (float) (textRect.x + (int) (tabWidth * (i + 1)));
                }

                if (getText() != null) {
                    String[] paragraphs = getText().split("\n");//Strings.split(getText(), '\n');

                    for (int i = 0; i < paragraphs.length; i++) {
                        if (paragraphs[i].length() == 0) {
                            paragraphs[i] = " ";
                        }
                        AttributedString as = new AttributedString(paragraphs[i]);
                        as.addAttribute(TextAttribute.FONT, font);
                        if (isUnderlined) {
                            as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
                        }
                        int tabCount = paragraphs[i].split("\t").length - 1;
                        Rectangle2D.Double paragraphBounds = new Paragraph(
                                    null, as.getIterator(),
                                    verticalPos, maxVerticalPos, leftMargin, rightMargin, tabStops, tabCount, getFontRenderContext()).getParagraph();
                        verticalPos = (float) (paragraphBounds.y + paragraphBounds.height);
                        textRect.add(paragraphBounds);
                    }
                }
            }
        }
        return new Dimension2DDouble(Math.abs(textRect.x) + textRect.width, Math.abs(textRect.y) + textRect.height);
    }

    public SVGTextAreaFigure clone() {
        SVGTextAreaFigure that = (SVGTextAreaFigure) super.clone();
        that.bounds = (Rectangle2D.Double) this.bounds.clone();
        return that;
    }
}


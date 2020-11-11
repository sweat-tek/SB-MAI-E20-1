/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.util.Iterator;
import java.util.LinkedList;
import org.jhotdraw.app.JHotDrawFeatures;

/**
 *
 * @author askel
 */
public class Paragraph {
    private GeneralPath shape;
    private AttributedCharacterIterator styledText;
    private float verticalPos;
    private float maxVerticalPos;
    private float leftMargin;
    private float rightMargin;
    private float[] tabStops; 
    private int tabCount;
    private FontRenderContext fontRenderContext;
    private float maxAscent = 0, maxDescent = 0;
    
    /**
     * Appends a paragraph of text at the specified y location and returns
     * the bounds of the paragraph.
     * 
     *
     * @param shape Shape to which to add the glyphs of the paragraph. This 
     * parameter is null, if we only want to measure the size of the paragraph.
     * @param styledText the text of the paragraph.
     * @param verticalPos the top bound of the paragraph
     * @param maxVerticalPos the bottom bound of the paragraph
     * @param leftMargin the left bound of the paragraph
     * @param rightMargin the right bound of the paragraph
     * @param tabStops an array with tab stops
     * @param tabCount the number of entries in tabStops which contain actual
     *        values
     * @return Returns the actual bounds of the paragraph.
     */
    Paragraph(GeneralPath shape, AttributedCharacterIterator styledText,
            float verticalPos, float maxVerticalPos,float leftMargin, 
            float rightMargin, float[] tabStops, int tabCount,
            FontRenderContext fontRenderContext) {
        
        this.shape = shape;
        this.styledText = styledText;
        this.verticalPos = verticalPos;
        this.maxVerticalPos = maxVerticalPos;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.tabStops = tabStops; 
        this.tabCount = tabCount;
        this.fontRenderContext = fontRenderContext;
    }
    
    @FeatureEntryPoint(JHotDrawFeatures.TEXT_AREA_TOOL)
    public Rectangle2D.Double getParagraph() {

        // assume styledText is an AttributedCharacterIterator, and the number
        // of tabs in styledText is tabCount
        Rectangle2D.Double paragraphBounds = new Rectangle2D.Double(leftMargin, verticalPos, 0, 0);

        LineBreakMeasurer measurer = new LineBreakMeasurer(styledText, fontRenderContext);

        while (measurer.getPosition() < styledText.getEndIndex()) {

            LinkedList<TextLayout> layouts = new LinkedList<TextLayout>();
            LinkedList<Float> penPositions = new LinkedList<Float>();
            
            createLayouts(layouts,penPositions,measurer);
            verticalPos += maxAscent;
            if (verticalPos > maxVerticalPos) {
                break;
            }
            Iterator<TextLayout> layoutEnum = layouts.iterator();
            Iterator<Float> positionEnum = penPositions.iterator();
            Iterator<TextLayout> layoutEnum2 = layouts.iterator();
            Iterator<Float> positionEnum2 = penPositions.iterator();

            // now iterate through layouts and draw them
            shape = createShape(layoutEnum, positionEnum, shape);
            paragraphBounds = createParagraphBounds(layoutEnum2,positionEnum2,paragraphBounds);

            verticalPos += maxDescent;
        }

        return paragraphBounds;
    }
    
    private int[] createTabLocations(AttributedCharacterIterator styledText, int tabCount) {
      int[] tabLocations = new int[tabCount + 1];

        int i = 0;
        for (char c = styledText.first(); c != styledText.DONE; c = styledText.next()) {
            if (c == '\t') {
                tabLocations[i++] = styledText.getIndex();
            }
        }
        tabLocations[tabCount] = styledText.getEndIndex() - 1;
        
        return tabLocations;
    }
    
    private GeneralPath createShape(Iterator<TextLayout> layoutEnum, Iterator<Float> positionEnum, GeneralPath shape) {
       while (layoutEnum.hasNext()) {
                TextLayout nextLayout = layoutEnum.next();
                float nextPosition = positionEnum.next();
                AffineTransform tx = new AffineTransform();
                tx.translate(nextPosition, verticalPos);
                if (shape != null) {
                    Shape outline = nextLayout.getOutline(tx);
                    shape.append(outline, false);
                }
            }
       return shape;
    }

    private Rectangle2D.Double createParagraphBounds(Iterator<TextLayout> layoutEnum, Iterator<Float> positionEnum, Rectangle2D.Double paragraphBounds) {
        while (layoutEnum.hasNext()) {
                TextLayout nextLayout = layoutEnum.next();
                float nextPosition = positionEnum.next();
                Rectangle2D layoutBounds = nextLayout.getBounds();
                paragraphBounds.add(new Rectangle2D.Double(layoutBounds.getX() + nextPosition,
                        layoutBounds.getY() + verticalPos,
                        layoutBounds.getWidth(),
                        layoutBounds.getHeight()));
            } 
        return paragraphBounds;
    }
            // Lay out and draw each line.  All segments on a line
            // must be computed before any drawing can occur, since
            // we must know the largest ascent on the line.
            // TextLayouts are computed and stored in a List;
            // their horizontal positions are stored in a parallel
            // List.
            // lineContainsText is true after first segment is drawn
    private void createLayouts(LinkedList<TextLayout> layouts, LinkedList<Float> penPositions,
                                LineBreakMeasurer measurer) {
        int[] tabLocations = createTabLocations(styledText, tabCount);
        int currentTab = 0;
        boolean lineContainsText = false;
        boolean lineComplete = false;
        float horizontalPos = leftMargin;
        while (!lineComplete) {
                float wrappingWidth = rightMargin - horizontalPos;
                TextLayout layout = null;
                layout =
                        measurer.nextLayout(wrappingWidth,
                        tabLocations[currentTab] + 1,
                        lineContainsText);

                // layout can be null if lineContainsText is true
                if (layout != null) {
                    layouts.add(layout);
                    penPositions.add(horizontalPos);
                    horizontalPos += layout.getAdvance();
                    maxAscent = Math.max(maxAscent, layout.getAscent());
                    maxDescent = Math.max(maxDescent,
                            layout.getDescent() + layout.getLeading());
                } else {
                    lineComplete = true;
                }

                lineContainsText = true;

                if (measurer.getPosition() == tabLocations[currentTab] + 1) {
                    currentTab++;
                }

                if (measurer.getPosition() == styledText.getEndIndex()) {
                    lineComplete = true;
                } else if (tabStops.length == 0 || horizontalPos >= tabStops[tabStops.length - 1]) {
                    lineComplete = true;
                }
                if (!lineComplete) {
                    // move to next tab stop
                    int j;
                    for (j = 0; horizontalPos >= tabStops[j]; j++) {
                    }
                    horizontalPos = tabStops[j];
                }
            }
    }
}

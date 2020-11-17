/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui.plaf.palette;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import org.apache.batik.ext.awt.LinearGradientPaint;
import org.apache.batik.ext.awt.MultipleGradientPaint;

/**
 *
 * @author tobia
 */
abstract public class AbstractPaletteBorder implements Border,UIResource
{   
    protected void drawBorder(Component c, int width, Graphics2D g, int borderColor, int x, int y, int height, float[] stops, Color[] stopColors)
    {
        String segmentPosition = getSegmentPosition(c);
        if (segmentPosition == "first" || segmentPosition == "middle")
        {
            width += 1;
        }
        g.setColor(new Color(borderColor, true));
        g.drawRect(x, y, width - 1, height - 1);
        LinearGradientPaint lgp = new LinearGradientPaint(new Point2D.Float(x, y), new Point2D.Float(x, y + height - 1), stops, stopColors, MultipleGradientPaint.REPEAT, MultipleGradientPaint.LINEAR_RGB);
        g.setPaint(lgp);
        g.fillRect(x + 1, y + 1, width - 2, height - 2);
    }
    
        private String getSegmentPosition(Component c) {
        String segmentPosition = null;
        if (c instanceof JComponent) {
        segmentPosition = (String) ((JComponent) c).getClientProperty("Palette.Component.segmentPosition");
        }
        return (segmentPosition == null) ? "only" : segmentPosition;
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
        Insets insets;
        String segmentPosition = getSegmentPosition(c);
        if (segmentPosition == "first" ||
                segmentPosition == "middle") {
            insets = new Insets(3, 3, 3, 2);
        } else {
            insets = new Insets(3, 3, 3, 3);
        }
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
    
}

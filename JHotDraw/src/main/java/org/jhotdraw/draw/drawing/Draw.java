/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.drawing;

import java.awt.Graphics2D;
import org.jhotdraw.draw.Figure;

/**
 *
 * @author oscar
 */
public abstract class Draw {

    public abstract void draw(Graphics2D g, Figure figure, Drawable drawable);
}

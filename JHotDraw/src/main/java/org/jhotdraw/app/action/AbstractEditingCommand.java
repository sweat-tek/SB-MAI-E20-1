/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import javax.swing.AbstractAction;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Naimo Ibrahim
 */
public abstract class AbstractEditingCommand extends AbstractAction {

    protected ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
    

    public AbstractEditingCommand(String ID) {
        labels.configureAction(this, ID);
    }
    
    public Component getFocusOwner() {
        Component focus = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
        return focus;
    }
   
}

package org.jhotdraw.app.action;
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
/**
 * Redoes the last user action.
 * In order to work, this action requires that the View returns a project
 * specific undo action when invoking getAction("redo") on the View.
 * 
 * Is the specifc implementation for redoing, extending AUndoRedoAction. 
 * 
 * @author Werner Randelshofer
 * @version 6.9 2020 Reworked.
 * <br>1.0 October 9, 2005 Created.
 */
public class RedoAction extends AUndoRedoAction {
    public final static String ID = "edit.redo";
    
    //Cannot be declared in super-class.
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
 
    
    /** Creates a new instance. */
    public RedoAction(Application app) {
        super(app);
        setID(ID);
        labels.configureAction(this, ID);
    }
}
package org.jhotdraw.app.action;
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
/**
 * Undoes the last user action.
 * In order to work, this action requires that the View returns a view-specific 
 * undo action when invoking getAction(UndoAction.ID) on the View.
 *
 * Is the specifc implementation for undoing, extending AUndoRedoAction. 
 * 
 * @author Werner Randelshofer
 * @version 6.9 2020 Reworked.
 * <br>1.0 October 9, 2005 Created.
 */
public class UndoAction extends AUndoRedoAction {
    public final static String ID = "edit.undo";
    
    //Cannot be declared in super-class.
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
   
    
    /** Creates a new instance. */
    public UndoAction(Application app) {
        super(app);
        setID(ID);
        labels.configureAction(this, ID);
    }
}
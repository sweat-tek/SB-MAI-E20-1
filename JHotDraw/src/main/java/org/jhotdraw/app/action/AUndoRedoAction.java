package org.jhotdraw.app.action;
import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;

/**
 *<h1>Abstract class that handles undo and redo actions</h1>
 * This class overrides AbstractViewAction methods to enable undo-redo actions.
 * 
 * @author Ryge
 * 
 */

public abstract class AUndoRedoAction extends AbstractViewAction {
    private String ID;

    
    /** Creates a new instance. */
    public AUndoRedoAction(Application app) {
        super(app);
    }
    
    private PropertyChangeListener redoActionPropertyListener = new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if (name == AbstractAction.NAME) {
                putValue(AbstractAction.NAME, evt.getNewValue());
            } else if (name == "enabled") {
                updateEnabledState();
            }
        }
    };
    
    /**
     * Sets the action ID
     * @param ID The action ID to perform.
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    
    /**
     * Updates EnabledState - checks if undo/redo is possible.
     */
    protected void updateEnabledState() {
        boolean isEnabled = false;
        Action realRedoAction = getRealRedoAction();
        if (realRedoAction != null) {
            isEnabled = realRedoAction.isEnabled();
        }
        setEnabled(isEnabled);
    }
    
    /**
     * Updates view if new view != null.
     * @param oldValue The old view
     * @param newValue The new view
     */
    @Override protected void updateView(View oldValue, View newValue) {
        super.updateView(oldValue, newValue);
        if (newValue != null && newValue.getAction(ID) !=  null) {
            putValue(AbstractAction.NAME, newValue.getAction(ID).getValue(AbstractAction.NAME));
            updateEnabledState();
        }
    }
    /**
     * Installs listeners on the view object.
     * @param p The view to install on.
     */
    @Override protected void installViewListeners(View p) {
        super.installViewListeners(p);
        if (p.getAction(ID) != null) {
        p.getAction(ID).addPropertyChangeListener(redoActionPropertyListener);
        }
    }
    /**
     * Installs listeners on the view object.
     * @param p The view to install on.
     */
    @Override protected void uninstallViewListeners(View p) {
        super.uninstallViewListeners(p);
        if (p.getAction(ID) != null) {
        p.getAction(ID).removePropertyChangeListener(redoActionPropertyListener);
        }
    }
    
    /**
     * Performs the action.
     */
    @FeatureEntryPoint(JHotDrawFeatures.UNDO_REDO)
    public void actionPerformed(ActionEvent e) {
        Action realRedoAction = getRealRedoAction();
        if (realRedoAction != null) {
            realRedoAction.actionPerformed(e);
        }
    }
    
    /**
     * Gets the action to perform.
     * @returns activeView
     */
    private Action getRealRedoAction() {
        return (getActiveView() == null) ? null : getActiveView().getAction(ID);
    }
    
}

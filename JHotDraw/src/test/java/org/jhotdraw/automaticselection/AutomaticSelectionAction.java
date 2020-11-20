package org.jhotdraw.automaticselection;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.junit.Assert;

public class AutomaticSelectionAction extends Stage<AutomaticSelectionAction> {

    @ExpectedScenarioState
    private DefaultDrawingView defaultDrawingView;

    public AutomaticSelectionAction figures_selected() {
        Assert.assertEquals(0, defaultDrawingView.getSelectionCount());
        defaultDrawingView.selectAll();
        Assert.assertNotEquals(0, defaultDrawingView.getSelectionCount());
        return self();
    }
}

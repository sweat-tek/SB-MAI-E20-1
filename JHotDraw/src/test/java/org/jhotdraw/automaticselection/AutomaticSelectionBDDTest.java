package org.jhotdraw.automaticselection;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class AutomaticSelectionBDDTest extends ScenarioTest<FiguresState, AutomaticSelectionAction, FiguresSelectedOutcome> {

    @Test
    public void automatic_selection() {
        given().figures_drawn();
        when().figures_selected();
        then().figures_are_selected();
    }
}

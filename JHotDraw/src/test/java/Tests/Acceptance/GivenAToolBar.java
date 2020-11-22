/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.gui.ToolsToolBar;

///**
// *
// * @author NidaBasaran
// */
public class GivenAToolBar extends Stage<GivenAToolBar> {

    @ProvidedScenarioState
    private ToolsToolBar toolBar;

    public GivenAToolBar AToolbar() {
        this.toolBar = new ToolsToolBar();
        return this;
    }
}
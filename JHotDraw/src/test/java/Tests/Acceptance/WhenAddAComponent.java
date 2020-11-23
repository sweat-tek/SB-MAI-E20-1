/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Component;
import org.jhotdraw.samples.svg.gui.ToolsToolBar;
import org.mockito.Mock;
import org.mockito.Mockito;
/**
 *
 * @author NidaBasaran
 */
public class WhenAddAComponent extends Stage<WhenAddAComponent> {

    @ExpectedScenarioState
    private ToolsToolBar toolbar;

    @Mock
    Component component;

    public WhenAddAComponent addAComponent() {
        component = Mockito.mock(Component.class);
        System.out.println("sadasdasdasda" + component);
        this.toolbar.add(component);

        return this;
    }

}
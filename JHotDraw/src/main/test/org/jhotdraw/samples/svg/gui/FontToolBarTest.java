import org.jhotdraw.samples.svg.gui.FontToolBar;
import org.jhotdraw.samples.svg.gui.FontToolBarUI;

public class FontToolBarTest {
    private FontToolBar fontToolBar;

    @org.junit.Before
    public void setUp() throws Exception {
        fontToolBar = new FontToolBar();
        fontToolBarUI = new FontToolBarUI();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        fontToolBar = null;
        fontToolBarUI = null;
    }

    @org.junit.Test
    public void createDisclosedComponent_With_InvalidState_Returns_Null() {
        JPanel panelWithStateMinus1 = (JPanel) fontToolBar.createDisclosedComponent(-1);
        JPanel panelWithState0 = (JPanel) fontToolBar.createDisclosedComponent(0);
        JPanel panelWithState3 = (JPanel) fontToolBar.createDisclosedComponent(3);
        JPanel panelWithState99 = (JPanel) fontToolBar.createDisclosedComponent(99);
        assertNull(panelWithStateMinus1);
        assertNull(panelWithState0);
        assertNull(panelWithState3);
        assertNull(panelWithState99);
    }

    @org.junit.Test
    public void createDisclosedComponent_With_State1_Creates_FontToolBar() {
        // TODO: Missing
    }

    @org.junit.Test
    public void createDisclosedComponent_With_State2_Creates_FontToolBar() {
        // TODO: Missing
    }

}

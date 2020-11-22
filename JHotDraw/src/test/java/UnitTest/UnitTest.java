/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;
import java.awt.Component;
import org.jhotdraw.samples.svg.gui.ToolsToolBar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author NidaBasaran
 */
public class UnitTest {
    private ToolsToolBar toolbar;
    @Mock
    Component component;

    @Before
    public void setUp() {
        this.toolbar = new ToolsToolBar();
        component = Mockito.mock(Component.class);
    }

    @Test
    public void testAddComponent() {
        toolbar.add(component);
        int components = toolbar.getComponentCount();

        assertNotEquals(components, 0);
        assertTrue(components > 0);

        toolbar.removeAll();

        components = toolbar.getComponentCount();

        assertEquals(components, 0);
    }
}
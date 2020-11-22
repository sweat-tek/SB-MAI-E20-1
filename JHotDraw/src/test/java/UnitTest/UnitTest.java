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
    private ToolsToolBar toolBar;
    @Mock
    Component component;

    @Before
    public void setUp() {
        this.toolBar = new ToolsToolBar();
        component = Mockito.mock(Component.class);
    }

    @Test
    public void testAddComponent() {
        toolBar.add(component);
        int components = toolBar.getComponentCount();

        assertNotEquals(components, 0);
        assertTrue(components > 0);

        toolBar.removeAll();

        components = toolBar.getComponentCount();

        assertEquals(components, 0);
    }
}
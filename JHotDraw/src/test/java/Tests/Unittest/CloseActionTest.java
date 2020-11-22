/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Unittest;

import org.jhotdraw.app.Application;
import static org.mockito.Mockito.mock;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.CloseAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 *
 * @author hala_
 */
public class CloseActionTest {

    Application application = mock(Application.class);
    CloseAction closeAction = mock(CloseAction.class);
    View view = mock(View.class);

    @Before
    public void setUp() {
        closeAction = new CloseAction(application);
    }

    @After
    public void tearDown() {
        closeAction = null;
    }

    @Test
    public void doItNullTest() {
        closeAction.doIt(null);
    }

    @Test
    public void doItAppNullTest() {
        doReturn(null).when(view).getApplication();
        closeAction.doIt(view);
    }

    @Test
    public void doItTest() {
        doNothing().when(application).dispose(view);
        doReturn(application).when(view).getApplication();
        closeAction.doIt(view);
        verify(application).dispose(view);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;

/**
 *
 * @author hala_
 */
public class GivenAnOpenWindow extends Stage<GivenAnOpenWindow>{
    @ProvidedScenarioState
    Application application = mock(Application.class);
    
    public GivenAnOpenWindow givenAnOpenWindow() {
        View view = mock(View.class);
        doReturn(false).when(view).hasUnsavedChanges();
        doReturn(true).when(view).isEnabled();
        List<View> views = new ArrayList<>();
        views.add(view);
        doReturn(views).when(application).views();
        return self();
    }
}

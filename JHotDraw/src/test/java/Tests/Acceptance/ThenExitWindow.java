/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author hala_
 */
public class ThenExitWindow extends Stage<ThenExitWindow>{
   
    @ExpectedScenarioState
    Exception exception;
    
    public ThenExitWindow thenExitWindow(){
        assertThat(exception = null);
        return self();
    }
}

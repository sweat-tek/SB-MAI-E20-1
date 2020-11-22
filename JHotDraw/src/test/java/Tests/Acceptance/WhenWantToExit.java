/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Acceptance;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.security.Permission;
import org.jhotdraw.app.Application;

/**
 *
 * @author hala_
 */
public class WhenWantToExit extends Stage<WhenWantToExit> {

    @ExpectedScenarioState
    Application application;

    public WhenWantToExit whenWantToExit() {
        securityManager = System.getSecurityManager();
        System.setSecurityManager(securityManager);
        return self();
    }

    private SecurityManager securityManager = new SecurityManager() {
      public void checkPermission(Permission permission){
      }
    };
}

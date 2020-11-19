/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.acceptance_test;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author ngram
 */
public class MyShinyAlignToolbarAcceptenceTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutCome> {
    
    @Test
    public void something_should_happen() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }
}

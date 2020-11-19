/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.acceptance_test;

import com.tngtech.jgiven.Stage;

/**
 *
 * @author ngram
 */
public class GivenSomeState extends Stage<GivenSomeState> {
    public GivenSomeState some_state() {
        String a = "a";
        return self();
    }
}
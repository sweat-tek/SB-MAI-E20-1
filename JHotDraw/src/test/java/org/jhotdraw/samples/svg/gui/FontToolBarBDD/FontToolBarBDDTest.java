package org.jhotdraw.samples.svg.gui.FontToolBarBDD;

import com.tngtech.jgiven.junit.ScenarioTest;

import org.junit.Test;

public class FontToolBarBDDTest extends ScenarioTest<GivenTextSelected, WhenSetBold, ThenTextIsBold> {
    @Test
    public void font_tool_bar() {
        given().text_selected();
        when().set_bold();
        then().text_is_bold();
    }
}




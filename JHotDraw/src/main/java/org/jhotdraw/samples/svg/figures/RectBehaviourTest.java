package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class RectBehaviourTest extends ScenarioTest<GivenRect, WhenEnlargen, ThenRectIsEnlarged> {
    
    @Test
    public void rectEnglarging() {
        System.out.println("Test for selecting and enlarging a Rectangle");
        given().aRect();
        when.selectedAndEnlarged();
        then().rectIsEnlarged();
    }
    
}

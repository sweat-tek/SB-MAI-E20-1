package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;


/**
 *
 * @author Firefigher
 */

public class BezierAcceptanceTest extends ScenarioTest<GivenActiveBezierTool, MouseClickDragAndRelease, ThenBezierFigureIsCreated>{
    
    @Test
    public void BezierAcceptanceTest() {
        
        given().givenActiveBezierTool();
        when().mouseClickDragAndRelease();
        then().thenBezierFigureIsCreated();
    }
}

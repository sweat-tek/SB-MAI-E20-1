package texttool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.junit.SimpleScenarioTest;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Assert;
import org.junit.Test;


public class JGivenTextToolTest extends SimpleScenarioTest<JGivenTextToolTest.SVGTextFigureTestSteps> {

    @Test
    public void svgTextFigure_fontSize_and_text_should_change() {
        String customText = "cool";
        float customFontSize = 10;

        given().a_svgTextFigure_with_customized_text_and_fontSize(customText, customFontSize);

        String newText = "notcool";
        float newCustomFontSize = 20;

        when().text_is_changed(newText).and().font_size_is_changed(newCustomFontSize);

        then().text_has_changed(customText, newText).and().font_size_has_changed(customFontSize, newCustomFontSize);
    }

    @Test
    public void svgTextFigure_made_unselectable() {

        given().a_svgTextFigure_with_customized_text_and_fontSize("hello", 14);

        when().svgTextFigure_is_made_unselectable();

        then().svgTextFigure_has_been_made_unselectable();
    }


    public static class SVGTextFigureTestSteps extends Stage<SVGTextFigureTestSteps> {

        private SVGTextFigure svgTextFigure;

        public void a_svgTextFigure_with_customized_text_and_fontSize(String text, float fontSize) {
            svgTextFigure = new SVGTextFigure(text);
            svgTextFigure.setFontSize(fontSize);
        }

        public SVGTextFigureTestSteps text_is_changed(String text) {
            svgTextFigure.setText(text);
            return this;
        }

        public void font_size_is_changed(float fontSize) {
            svgTextFigure.setFontSize(fontSize);
        }

        public SVGTextFigureTestSteps text_has_changed(String original, String newText) {
            Assert.assertNotEquals("Text has changed", original, newText);
            return this;
        }

        public void font_size_has_changed(float original, float newFontSize) {
            Assert.assertNotEquals("FontSize has changed", original, newFontSize);
        }

        public void svgTextFigure_is_made_unselectable() {
            svgTextFigure.setSelectable(false);
        }

        public void svgTextFigure_has_been_made_unselectable() {
            Assert.assertFalse("SVGTextfigure is unselectable", svgTextFigure.isSelectable());
        }
    }
}

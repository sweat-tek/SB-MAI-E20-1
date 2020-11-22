/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

/**
 *
 * @author nadinfariss
 */
public class GivenAnImageFigure extends Stage<GivenAnImageFigure> {

    @ProvidedScenarioState
    SVGImageFigure image;

    public GivenAnImageFigure SelectedImage() {
        this.image = new SVGImageFigure();
        return this;

    }

}

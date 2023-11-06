import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PaletteParameters {
    private ArrayList<ColorTarget> colorsTargets;

    public PaletteParameters(){
        this.colorsTargets = new ArrayList<ColorTarget>(){{
            add(new ColorTarget(150, new Color(250, 255, 255, 255)));
            add(new ColorTarget(130, new Color(255, 255, 200, 255)));
            add(new ColorTarget(112, new Color(235, 235, 40, 250)));
            add(new ColorTarget(72, new Color(200, 100, 0, 180)));
            add(new ColorTarget(60, new Color(155, 0, 0, 110)));
            add(new ColorTarget(55, new Color(0, 0, 0, 100)));
        }};
    }

    public ArrayList<ColorTarget> getColorsTargets() {
        return colorsTargets;
    }

    public void setColorsTargets(ArrayList<ColorTarget> colorsTargets) {
        this.colorsTargets = colorsTargets;
    }
}

import java.awt.*;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class FireController{
    private FireView fireView;
    private FireModel fireModel;
    private DTOGeneralParameters dtoGeneralParameters;

    private PaletteParameters paletteParameters;

    private TemperatureParameters temperatureParameters;

    public FireController(){
        this.dtoGeneralParameters = new DTOGeneralParameters();
        this.temperatureParameters = new TemperatureParameters();
        this.paletteParameters = new PaletteParameters();
        this.initClass();
        this.fireView.pack();
        this.fireView.setVisible(true);
    }

    public static void main(String[] args) {
        FireController ft = new FireController();

        ft.playAnimation();
    }

    public void playAnimation() {
        while (true) {
            if (this.fireView.getControlPanel().getAnimationControls().getPlayPause().isSelected()) {
                this.fireView.getViewer().paintBackground();
                this.fireView.getViewer().paintForegroundImage();
            }

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    public void updateValues(){
        Temperatures temperatures = new Temperatures(dtoGeneralParameters.getFireWidth(), dtoGeneralParameters.getFireHeight(),
                this.temperatureParameters.getNewColdPixelPercentage(), this.temperatureParameters.getNewHotPixelPercentage(), this.temperatureParameters);

        ColorPalette palette = new ColorPalette(this.paletteParameters.getColorsTargets());

        this.fireModel = new FireModel(dtoGeneralParameters.getFireWidth(), dtoGeneralParameters.getFireHeight(),
                dtoGeneralParameters.getFireXPosition(), dtoGeneralParameters.getFireYPosition(),
                temperatures, palette);

        this.fireView.getViewer().setForegroundImg(this.fireModel);
        this.fireView.getViewer().setBackgroundImg(this.dtoGeneralParameters.getBackgroundImage());
    }

    private void initClass(){
        int widthAnimation = dtoGeneralParameters.getFireWidth();
        int heightAnimation = dtoGeneralParameters.getFireHeight();
        ColorPalette palette = new ColorPalette(this.paletteParameters.getColorsTargets());

        Temperatures temperatures = new Temperatures(widthAnimation, heightAnimation,
                temperatureParameters.getNewColdPixelPercentage(), temperatureParameters.getNewHotPixelPercentage(), this.temperatureParameters);

        this.fireModel = new FireModel(widthAnimation, heightAnimation,
                dtoGeneralParameters.getFireXPosition(), dtoGeneralParameters.getFireYPosition(),
                temperatures, palette);


        this.fireView = new FireView(this.fireModel, this.dtoGeneralParameters, this,
                this.temperatureParameters, this.paletteParameters);
    }
}

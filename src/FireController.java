import java.awt.*;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class FireController{
    private FireView fireView;
    private FireModel fireModel;
    private DTOGeneralParameters dtoGeneralParameters;

    public FireController(){
        this.dtoGeneralParameters = new DTOGeneralParameters();
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

    private void initClass(){
        int widthAnimation = dtoGeneralParameters.getFireWidth();
        int heightAnimation = dtoGeneralParameters.getFireHeight();
        ColorPalette palette = new ColorPalette(new ArrayList<ColorTarget>(){{
            add(new ColorTarget(150, new Color(250, 255, 255, 255)));
            add(new ColorTarget(130, new Color(255, 255, 200, 255)));
            add(new ColorTarget(112, new Color(235, 235, 40, 250)));
            add(new ColorTarget(72, new Color(200, 100, 0, 180)));
            add(new ColorTarget(60, new Color(155, 0, 0, 110)));
            add(new ColorTarget(55, new Color(0, 0, 0, 100)));
        }});

        Temperatures temperatures = new Temperatures(widthAnimation, heightAnimation, 0.25, 0.09);

        this.fireModel = new FireModel(widthAnimation, heightAnimation,
                dtoGeneralParameters.getFireXPosition(), dtoGeneralParameters.getFireYPosition(),
                temperatures, palette);


        this.fireView = new FireView(this.fireModel, dtoGeneralParameters, this);

    }
}

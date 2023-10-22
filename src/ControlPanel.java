import javax.swing.*;

public class ControlPanel extends JPanel {
    private AnimationControls animationControls;
    private GeneralParameters generalParameters;

    public ControlPanel(Viewer viewer, int fireWidth, int fireHeight, int fireXPosition, int fireYPosition) {
        this.animationControls = new AnimationControls(viewer);
        this.generalParameters = new GeneralParameters(fireWidth, fireHeight, fireXPosition, fireYPosition);
    }

    public AnimationControls getAnimationControls() {
        return animationControls;
    }

    public void setAnimationControls(AnimationControls animationControls) {
        this.animationControls = animationControls;
    }

    public GeneralParameters getGeneralParameters() {
        return generalParameters;
    }

    public void setGeneralParameters(GeneralParameters generalParameters) {
        this.generalParameters = generalParameters;
    }
}

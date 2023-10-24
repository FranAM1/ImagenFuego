import javax.swing.*;
import java.awt.*;

public class GeneralParameters {
    private JTextField fireWidth, fireHeight;

    private JTextField fireXPosition, fireYPosition;

    private JTextField calcFramesPerSecond, showFramesPerSecond;

    private Image backgroundImage;

    public GeneralParameters(int fireWidth, int fireHeight, int fireXPosition, int fireYPosition) {
        this.fireWidth = new JTextField(String.valueOf(fireWidth));
        this.fireHeight = new JTextField(String.valueOf(fireHeight));
        this.fireXPosition = new JTextField(String.valueOf(fireXPosition));
        this.fireYPosition = new JTextField(String.valueOf(fireYPosition));
        this.calcFramesPerSecond = new JTextField("0");
        this.showFramesPerSecond = new JTextField("0");
        this.backgroundImage = null;
    }

    public JTextField getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(JTextField fireWidth) {
        this.fireWidth = fireWidth;
    }

    public JTextField getFireHeight() {
        return fireHeight;
    }

    public void setFireHeight(JTextField fireHeight) {
        this.fireHeight = fireHeight;
    }

    public JTextField getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(JTextField fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public JTextField getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(JTextField fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public JTextField getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(JTextField calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public JTextField getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(JTextField showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}

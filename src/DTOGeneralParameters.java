import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DTOGeneralParameters {
    private int fireWidth, fireHeight;

    private int fireXPosition, fireYPosition;

    private Image backgroundImage;
    private String imageName, imagePath;

    private int calcFramesPerSecond, showFramesPerSecond;

    public DTOGeneralParameters() {
        this.fireWidth = 290;
        this.fireHeight = 150;
        this.fireXPosition = 300;
        this.fireYPosition = 405;
        File image = new File("bg.jpg");
        try {
            this.backgroundImage = ImageIO.read(image);
        } catch (Exception e) {
            System.err.println("Error loading defafult background. ");
            System.err.println(e);
        }
        this.imageName = image.getName();
        this.imagePath = image.getAbsolutePath();
    }

    public int getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(int fireWidth) {
        this.fireWidth = fireWidth;
    }

    public int getFireHeight() {
        return fireHeight;
    }

    public void setFireHeight(int fireHeight) {
        this.fireHeight = fireHeight;
    }

    public int getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(int fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public int getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(int fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public int getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(int calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public int getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(int showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

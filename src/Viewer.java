import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Viewer extends Canvas {
    private BufferedImage backgroundImg;


    public Viewer(int pixWidth, int pixHeight) {
        Dimension d = new Dimension(pixWidth, pixHeight);
        this.setPreferredSize(d);
        this.loadBackground();
    }


    private void loadBackground() {
        try {
            this.backgroundImg = ImageIO.read(new File("bg.jpg"));
            System.out.println("Background loaded :-)");
            System.out.println("Width: " + this.backgroundImg.getWidth());
            System.out.println("Height: " + this.backgroundImg.getHeight());
        } catch (IOException e) {
            System.err.println("Error loading background. ");
            System.err.println(e);
        }
    }


    @Override
    public void paint(Graphics g) {
        System.out.println("Overrided paint()");
        // this.myPaint();
    }
}

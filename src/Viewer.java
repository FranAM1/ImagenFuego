import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Viewer extends Canvas {
    private BufferedImage backgroundImg;
    private FireAnimation fa;


    public Viewer(int pixWidth, int pixHeight, ColorPalette palette) {
        Dimension d = new Dimension(pixWidth, pixHeight);
        this.setPreferredSize(d);
        this.loadBackground();
        this.fa = new FireAnimation(
                300, 150, 265, 390,
                new Temperatures(300, 150, 0.1, 0.3),
                palette
        );;

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

    public void showNewFrame() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.backgroundImg, 0, 0, null);
        g.drawImage(this.fa, this.fa.getPosX(), this.fa.getPosY(), null);
    }
}

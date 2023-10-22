import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;

public class Viewer extends Canvas {
    private BufferedImage backgroundImg;
    private FireModel foregroundImg;
    private BufferStrategy bs;


    public Viewer(int pixWidth, int pixHeight, FireModel foregroundImg) {
        Dimension d = new Dimension(pixWidth, pixHeight);
        this.setPreferredSize(d);
        this.loadBackground();
        this.foregroundImg = foregroundImg;
        this.bs = null;
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
        checkBufferStrategy();

        Graphics g = bs.getDrawGraphics();
        this.paintBackground();
        this.foregroundImg.next();
        this.paintForegroundImage();

        bs.show();
        g.dispose();
    }

    public void paintBackground() {
        checkBufferStrategy();

        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.backgroundImg, 0, 0, this.getWidth(), this.getHeight(), null);

        g.dispose();
    }

    public void paintForegroundImage() {
        checkBufferStrategy();

        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.foregroundImg, this.foregroundImg.getPosX(), this.foregroundImg.getPosY(), this.foregroundImg.getWidth(), this.foregroundImg.getHeight(), null);
        this.foregroundImg.next();

        bs.show();
        g.dispose();
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("Overrided paint()");
    }

    private void checkBufferStrategy(){
        if (this.bs == null) {
            System.out.println("kgd");
            this.createBufferStrategy(2);
            this.bs = this.getBufferStrategy();
        }
    }

    public BufferedImage getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(BufferedImage backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    public FireModel getForegroundImg() {
        return foregroundImg;
    }

    public void setForegroundImg(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;
    }
}

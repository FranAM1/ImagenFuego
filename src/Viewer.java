import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;

public class Viewer extends Canvas {
    private BufferedImage backgroundImg;
    private FireAnimation fa;
    private BufferStrategy bs;


    public Viewer(int pixWidth, int pixHeight, ColorPalette palette) {
        Dimension d = new Dimension(pixWidth, pixHeight);
        this.setPreferredSize(d);
        this.loadBackground();

        int faWidth = 290;
        int faHeight = 150;
        int faPosX = 300;
        int faPosY = 405;

        this.fa = new FireAnimation(
                faWidth, faHeight, faPosX, faPosY,
                new Temperatures(faWidth,faHeight,0.25, 0.09),
                palette
        );
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
        this.paintBackground(g);
        this.fa.run();
        this.paintFireAnimation(g);

        bs.show();
        g.dispose();
    }

    public void paintBackground(Graphics g) {
        g.drawImage(this.backgroundImg, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void paintFireAnimation(Graphics g) {
        g.drawImage(this.fa, this.fa.getPosX(), this.fa.getPosY(),this.fa.getWidth(),this.fa.getHeight(), null);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("Overrided paint()");
    }

    private void checkBufferStrategy(){
        if (this.bs == null) {
            System.out.println("kgd");
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }
    }

    public BufferedImage getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(BufferedImage backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public FireAnimation getFa() {
        return fa;
    }

    public void setFa(FireAnimation fa) {
        this.fa = fa;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;

public class Viewer extends Canvas {
    private Image backgroundImg;
    private FireModel foregroundImg;
    private BufferStrategy bs;
    private DTOGeneralParameters dtoGeneralParameters;


    public Viewer(int pixWidth, int pixHeight, FireModel foregroundImg, DTOGeneralParameters dtoGeneralParameters) {
        Dimension d = new Dimension(pixWidth, pixHeight);
        this.setPreferredSize(d);
        this.backgroundImg = dtoGeneralParameters.getBackgroundImage();
        this.foregroundImg = foregroundImg;
        this.bs = null;
    }

    public void paintBackground() {
        checkBufferStrategy();

        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.backgroundImg, 0, 0, this.getWidth(), this.getHeight(), null);

        g.dispose();
    }

    public void clearBackground() {
        checkBufferStrategy();

        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

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

    public Image getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(Image backgroundImg) {
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

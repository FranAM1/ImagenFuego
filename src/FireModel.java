import java.awt.*;
import java.awt.image.BufferedImage;

public class FireModel extends BufferedImage {
    private int width, height;
    private int posX, posY;
    private Temperatures temperatures;
    private ColorPalette palette;

    public FireModel(int width, int height, int posX, int posY, Temperatures temperatures, ColorPalette palette){
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        this.setWidth(width);
        this.setHeight(height);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setTemperatures(temperatures);
        this.setPalette(palette);
        this.initAllTransparent();
        this.palette.calc();
        this.next();
    }

    public void next(){
        this.createImage();
    }

    public void initAllTransparent() {
        Color color = new Color(0, 0, 0, 0);

        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                this.setRGB(x, y, color.getRGB());
            }
        }
    }

    private void createImage(){
        this.temperatures.next();

        for(int x = 0; x < this.getWidth(); x++){
            for(int y = 0; y < this.getHeight(); y++){
                int temp = this.temperatures.getTemp(x, y);
                int[] colors = palette.getColorsPalette()[temp];
                Color color = new Color(colors[0], colors[1], colors[2], colors[3]);
                this.setRGB(x, y, color.getRGB());
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Temperatures getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public ColorPalette getPalette() {
        return palette;
    }

    public void setPalette(ColorPalette palette) {
        this.palette = palette;
    }
}

import java.lang.reflect.Type;

public class FireAnimation {
    private int width, height;
    private int posX, posY;
    private Temperatures temperatures;
    private ColorPalette palette;

    public FireAnimation(int width, int height, int posX, int posY, Temperatures temperatures, ColorPalette palette){
        this.setWidth(width);
        this.setHeight(height);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setTemperatures(temperatures);
        this.setPalette(palette);
    }

    public void run(){

    }

    private void createImage(){

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

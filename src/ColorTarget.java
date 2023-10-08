import java.awt.*;

public class ColorTarget {
    private int temperature;

    private Color color;

    public ColorTarget(int temperature, Color color) {
        this.setTemperature(temperature);
        this.setColor(color);
    }

    public int getR(){
        return this.getColor().getRed();
    }

    public int getG(){
        return this.getColor().getGreen();
    }

    public int getB(){
        return this.getColor().getBlue();
    }

    public int getA(){
        return this.getColor().getAlpha();
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

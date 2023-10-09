import java.awt.*;
import java.util.ArrayList;

public class ColorPalette {
    private int[][] colorsPalette;
    private ArrayList<ColorTarget> palette;


    public ColorPalette(ArrayList<ColorTarget> colorsTargets) {
        this.setPalette(colorsTargets);
        this.setColorsPalette(this.addColorsTarget(this.getPalette()));
    }

    public void calc() {
        for(int i = 0; i < this.palette.size()-1; i++){
            int firstPosition = this.palette.get(i).getTemperature();
            int lastPosition = this.palette.get(i+1).getTemperature();

            int spaceBetween = lastPosition - firstPosition - 1;

            if (spaceBetween > 0){
                for(int j = 1; j < spaceBetween+1;j++){
                    Color firstColor = this.palette.get(i).getColor();
                    Color lastColor = this.palette.get(i+1).getColor();

                    this.colorsPalette[firstPosition+j] = calcIntervalColors(firstColor, lastColor, spaceBetween, j);
                }
            }
        }
    }

    private int[] calcIntervalColors(Color firstColor, Color lastColor, int spaceBetween, int position) {
        int[] colors = new int[4];

        int firstRed = firstColor.getRed();
        int firstGreen = firstColor.getGreen();
        int firstBlue = firstColor.getBlue();
        int firstAlpha = firstColor.getAlpha();

        int lastRed = lastColor.getRed();
        int lastGreen = lastColor.getGreen();
        int lastBlue = lastColor.getBlue();
        int lastAlpha = lastColor.getAlpha();

        int red = (int) (firstRed + position * ((lastRed - firstRed) / (double) (spaceBetween+1)));
        int green = (int) (firstGreen + position * ((lastGreen - firstGreen) / (double) (spaceBetween+1)));
        int blue = (int) (firstBlue + position * ((lastBlue - firstBlue) / (double) (spaceBetween+1)));
        int alpha = (int) (firstAlpha + position * ((lastAlpha - firstAlpha) / (double) (spaceBetween+1)));

        colors[0] = red;
        colors[1] = green;
        colors[2] = blue;
        colors[3] = alpha;

        return colors;
    }



    private int[][] addColorsTarget(ArrayList<ColorTarget> colorsTarget) {
        int[][] colors = new int[256][4];

        for (int i = 0; i < colorsTarget.size();i++){
            ColorTarget currentTarget = colorsTarget.get(i);

            int position = currentTarget.getTemperature();
            int alpha = currentTarget.getA();
            int red = currentTarget.getR();
            int green = currentTarget.getG();
            int blue = currentTarget.getB();

            colors[position] = new int[]{red, green, blue, alpha};
        }
        return colors;
    }
    public int[][] getColorsPalette(){
        return colorsPalette;
    }

    public void setColorsPalette(int[][] colorsPalette) {
        this.colorsPalette = colorsPalette;
    }

    public ArrayList<ColorTarget> getPalette() {
        return palette;
    }

    public void setPalette(ArrayList<ColorTarget> palette) {
        boolean is0onTarget = false;
        int index = 0;

        while(!is0onTarget && index < palette.size()){
            if(palette.get(index).getTemperature() == 0){
                is0onTarget = true;
            }else{
                index++;
            }
        }

        if(!is0onTarget){
            palette.add(new ColorTarget(0, new Color(0, 0, 0, 0)));
        }

        palette.sort((color1, color2) -> {
            if (color1.getTemperature() > color2.getTemperature()) {
                return 1;
            } else if (color1.getTemperature() < color2.getTemperature()) {
                return -1;
            } else {
                return 0;
            }
        });

        if (palette.get(palette.size() - 1).getTemperature() != 255) {
            palette.add(new ColorTarget(255, new Color(255, 255, 255, 255)));
        }

        this.palette = palette;
    }
}

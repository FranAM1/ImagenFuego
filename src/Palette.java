import java.util.ArrayList;

public class Palette {
    private int[][] colorsPalette;
    private ArrayList<Integer[]> colorsTargets;


    public Palette(ArrayList<Integer[]> colorsTargets) {
        this.setColorsTargets(colorsTargets);
        this.setColorsPalette(this.addColorsTarget(this.getColorsTargets()));
    }

    public void calc() {

    }

    private int[][] addColorsTarget(ArrayList<Integer[]> colorsTarget) {
        int[][] colors = new int[256][4];

        for (Integer[] integers : colorsTarget) {
            int position = integers[0];
            int addressable = integers[1];
            int red = integers[2];
            int green = integers[3];
            int blue = integers[4];

            colors[position] = new int[]{addressable, red, green, blue};
        }
        return colors;
    }
    public int[][] getColorsPalette() {
        return colorsPalette;
    }

    public void setColorsPalette(int[][] colorsPalette) {
        this.colorsPalette = colorsPalette;
    }

    public ArrayList<Integer[]> getColorsTargets() {
        return colorsTargets;
    }

    public void setColorsTargets(ArrayList<Integer[]> colorsTargets) {
        colorsTargets.sort((color1, color2) -> {
            if (color1[0] > color2[0]) {
                return 1;
            } else if (color1[0] < color2[0]) {
                return -1;
            } else {
                return 0;
            }
        });

        if (colorsTargets.get(colorsTargets.size() - 1)[0] != 255) {
            colorsTargets.add(new Integer[]{255, 255, 255, 255, 255});
        }

        this.colorsTargets = colorsTargets;
    }
}

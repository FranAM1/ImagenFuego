import java.util.ArrayList;

public class Palette {
    private int[][] colorsPalette;
    private ArrayList<Integer[]> colorsTargets;


    public Palette(ArrayList<Integer[]> colorsTargets) {
        this.setColorsTargets(colorsTargets);
        this.setColorsPalette(this.addColorsTarget(this.getColorsTargets()));
    }

    public void calc() {
        for(int i = 0; i < this.colorsTargets.size()-1;i++){
            int firstPosition = this.colorsTargets.get(i)[0];
            int lastPosition = this.colorsTargets.get(i+1)[0];

            int spaceBetween = lastPosition - firstPosition - 1;

            if (spaceBetween > 0){
                for(int j = 1; j < spaceBetween+1;j++){
                    for (int k = 0; k < this.colorsPalette[0].length;k++){
                        int firstValue = this.colorsTargets.get(i)[k+1];
                        int lastValue = this.colorsTargets.get(i+1)[k+1];

                        double value = j * ((lastValue - firstValue) / (double) (spaceBetween));

                        this.colorsPalette[firstPosition+j][k] = firstValue + (int) value;
                    }
                }
            }
        }
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
        boolean is0onTarget = false;
        int index = 0;

        while(!is0onTarget && index < colorsTargets.size()){
            if(colorsTargets.get(index)[0] == 0){
                is0onTarget = true;
            }else{
                index++;
            }
        }

        if(!is0onTarget){
            colorsTargets.add(new Integer[]{0,0,0,0,0});
        }

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

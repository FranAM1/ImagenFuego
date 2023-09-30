import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*int width = 10;
        int height = 4;
        double coldPoints = 0.1;
        double sparks = 0.3;


        Temperatures test = new Temperatures(width, height, coldPoints, sparks);

        test.next();

        test.printArray();*/

        ArrayList<Integer[]> colorsTargets = new ArrayList<>();

        colorsTargets.add(new Integer[]{255, 32, 4, 0, 5});
        colorsTargets.add(new Integer[]{150, 52, 5, 8, 25});
        colorsTargets.add(new Integer[]{200, 2, 57, 20, 32});
        colorsTargets.add(new Integer[]{100, 20, 0, 0, 80});



        Palette palette = new Palette(colorsTargets);

        for (Integer[] integers : colorsTargets) {
            System.out.println(Arrays.toString(integers));
        }

        /*for(int i = 0; i < palette.getColorsPalette().length; i++) {
            System.out.println(Arrays.toString(palette.getColorsPalette()[i]));
        }*/
    }
}
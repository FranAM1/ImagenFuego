import java.util.ArrayList;
import java.util.Arrays;

public class Temperatures {
    private ArrayList<Integer[]> arrayTemperatures;
    private int width;
    private int height;
    private double percentageColdPoints;
    private double percentageSparks;

    public Temperatures(int width, int height, double percentageColdPoints, double percentageSparks) {
        this.setWidth(width);
        this.setHeight(height);
        this.setPercentageColdPoints(percentageColdPoints);
        this.setPercentageSparks(percentageSparks);
        this.setArrayTemperatures(this.generateArray(width, height));
    }

    private ArrayList<Integer[]> generateArray(int width, int height){
        ArrayList<Integer[]> array = new ArrayList<Integer[]>();

        for(int i = 0; i < height; i++) {
            Integer[] row = new Integer[width];
            Arrays.fill(row, 0);
            array.add(row);
        }

        return array;
    }

    public void printArray() {
        for(int i = 0; i < height;i++){
            System.out.println(Arrays.toString(this.getArrayTemperatures().get(i)));
        }
    }

    public void next() {
        coldPoints();
        sparks();
        calc();
    }

    private void sparks() {
        for(int i = 0; i < this.getWidth(); i++) {
            double random = Math.random();

            if(random < this.getPercentageSparks()) {
                this.getArrayTemperatures().get(this.getHeight()-1)[i] = 255;
            }
        }
    }

    private void coldPoints() {
        for(int i = 0; i < this.getWidth(); i++) {
            double random = Math.random();

            if(random < this.getPercentageColdPoints()) {
                this.getArrayTemperatures().get(this.getHeight()-1)[i] = 0;
            }
        }
    }

    private void calc() {
        ArrayList<Integer[]> array = this.getArrayTemperatures();

        for(int i = this.getHeight()-2; i > -1;i--) {
            Integer[] row = array.get(i);
            Integer[] underRow = array.get(i+1);

            for(int j = 0; j < this.getWidth();j++) {
                int value = row[j];

                if(j==0) {
                    value += underRow[j] + underRow[j+1];
                }
                else if(j==this.getWidth()-1){
                    value += underRow[j] + underRow[j-1];
                }
                else {
                    value += underRow[j-1] + underRow[j] + underRow[j+1];
                }

                row[j] = value/4;
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

    public ArrayList<Integer[]> getArrayTemperatures() {
        return arrayTemperatures;
    }
    public void setArrayTemperatures(ArrayList<Integer[]> arrayTemperatures) {
        this.arrayTemperatures = arrayTemperatures;
    }

    public double getPercentageColdPoints() {
        return percentageColdPoints;
    }

    public void setPercentageColdPoints(double percentageColdPoints) {
        this.percentageColdPoints = percentageColdPoints;
    }

    public double getPercentageSparks() {
        return percentageSparks;
    }

    public void setPercentageSparks(double percentageSparks) {
        this.percentageSparks = percentageSparks;
    }


}
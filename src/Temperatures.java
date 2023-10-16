import java.util.Arrays;

public class Temperatures {
    private int[][] temperatures;
    private int width, height;
    private double coldPointsPercentage;
    private double sparksPercentage;

    public Temperatures(int width, int height, double percentageColdPoints, double percentageSparks) {
        this.setWidth(width);
        this.setHeight(height);
        this.setColdPointsPercentage(percentageColdPoints);
        this.setSparksPercentage(percentageSparks);
        this.setTemperatures(new int[height][width]);
    }

    public void printArray() {
        for(int i = 0; i < height;i++){
            System.out.println(Arrays.toString(this.temperatures[i]));
        }
    }

    public void next() {
        creatColdPoints();
        createSparks();
        calc();
   }

   public int getTemp(int x, int y){
        return this.temperatures[y][x];
   }

    private void createSparks() {
        for(int i = 0; i < this.getWidth(); i++) {
            double random = Math.random();

            if(random < this.sparksPercentage) {
                this.temperatures[height-1][i] = 255;
            }
        }
    }

    private void creatColdPoints(){
        for(int i = 0; i < this.getWidth(); i++) {
            double random = Math.random();

            if(random < this.coldPointsPercentage) {
                this.temperatures[height-1][i] = 0;
            }
        }
    }

    private void calc() {
        int[][] array = this.temperatures;

        for(int i = this.height-2; i > -1;i--) {
            int[] row = array[i];
            int[] underRow = array[i+1];

            for(int j = 2; j < this.getWidth()-2;j++) {
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

    public double getColdPointsPercentage() {
        return coldPointsPercentage;
    }

    public void setColdPointsPercentage(double coldPointsPercentage) {
        this.coldPointsPercentage = coldPointsPercentage;
    }

    public double getSparksPercentage() {
        return sparksPercentage;
    }

    public void setSparksPercentage(double sparksPercentage) {
        this.sparksPercentage = sparksPercentage;
    }

    public int[][] getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(int[][] temperatures) {
        this.temperatures = temperatures;
    }


}
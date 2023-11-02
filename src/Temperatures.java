import java.util.Arrays;

public class Temperatures {
    private int[][] temperatures;
    private int width, height;
    private double coldPointsPercentage;
    private double sparksPercentage;
    private TemperatureParameters temperatureParameters;

    public Temperatures(int width, int height, double percentageColdPoints, double percentageSparks, TemperatureParameters temperatureParameters) {
        this.setWidth(width);
        this.setHeight(height);
        this.setColdPointsPercentage(percentageColdPoints);
        this.setSparksPercentage(percentageSparks);
        this.setTemperatures(new int[height][width]);
        this.temperatureParameters = temperatureParameters;
    }

    public void resetTemperatures() {
        for(int i = 0; i < height;i++){
            for(int j = 0; j < width;j++){
                this.temperatures[i][j] = 0;
            }
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

            row[0] = 0;
            row[this.getWidth()-1] = 0;
            for(int j = 1; j < this.getWidth()-2;j++) {

                row[j] = ((int) ((row[j-1] * temperatureParameters.getCellsPonderation()[0][0]
                        + row[j] * temperatureParameters.getCellsPonderation()[0][1]
                        + row[j+1] * temperatureParameters.getCellsPonderation()[0][2]
                        + underRow[j-1] * temperatureParameters.getCellsPonderation()[1][0]
                        + underRow[j] * temperatureParameters.getCellsPonderation()[1][1]
                        + underRow[j+1] * temperatureParameters.getCellsPonderation()[1][2]) / 6
                        - 1.8));

                if (row[j] < 0) {
                    row[j] = 0;
                }else if(row[j] > 255){
                    row[j] = 255;
                }
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
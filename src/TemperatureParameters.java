public class TemperatureParameters {
    private double newColdPixelPercentage;
    private double newHotPixelPercentage;

    private double[][] cellsPonderation;

    private double cellsDivider;

    private double fixAtenuationFactor;

    private boolean bottonUpTemps;

    public TemperatureParameters() {
        this.newColdPixelPercentage = 0.25;
        this.newHotPixelPercentage = 0.09;
        this.cellsPonderation = new double[][]{
            {1.2, 1.5, 1.2},
            {0.7, 0.7, 0.7},
        };
        this.cellsDivider = 5.87;
        this.fixAtenuationFactor = 1.8;
        this.bottonUpTemps = false;
    }

    public double getNewColdPixelPercentage() {
        return newColdPixelPercentage;
    }

    public void setNewColdPixelPercentage(double newColdPixelPercentage) {
        this.newColdPixelPercentage = newColdPixelPercentage;
    }

    public double getNewHotPixelPercentage() {
        return newHotPixelPercentage;
    }

    public void setNewHotPixelPercentage(double newHotPixelPercentage) {
        this.newHotPixelPercentage = newHotPixelPercentage;
    }

    public double[][] getCellsPonderation() {
        return cellsPonderation;
    }

    public void setCellsPonderation(double[][] cellsPonderation) {
        this.cellsPonderation = cellsPonderation;
    }

    public double getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(double cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public double getFixAtenuationFactor() {
        return fixAtenuationFactor;
    }

    public void setFixAtenuationFactor(double fixAtenuationFactor) {
        this.fixAtenuationFactor = fixAtenuationFactor;
    }

    public boolean getBottonUpTemps() {
        return bottonUpTemps;
    }

    public void setBottonUpTemps(boolean bottonUpTemps) {
        this.bottonUpTemps = bottonUpTemps;
    }
}

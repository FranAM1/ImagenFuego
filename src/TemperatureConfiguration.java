import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class TemperatureConfiguration extends JPanel{
    private JSlider newColdPixelPercentage;
    private JSlider newHotPixelPercentage;
    private JTable cellsPonderation;
    private JSlider cellsDivider;
    private JSlider fixAttenuationFactor;
    private JToggleButton bottonUpTemps;

    public TemperatureConfiguration(ActionListener actionListener, TemperatureParameters temperatureParameters) {
        this.setLayout(new GridBagLayout());
        this.newColdPixelPercentage = new JSlider(0, 100, this.doublePercentageToInt(temperatureParameters.getNewColdPixelPercentage()));
        this.newColdPixelPercentage.setMajorTickSpacing(25);
        this.newColdPixelPercentage.setMinorTickSpacing(10);
        this.newColdPixelPercentage.setPaintTicks(true);
        this.newColdPixelPercentage.setPaintLabels(true);

        this.newHotPixelPercentage = new JSlider(0, 100, this.doublePercentageToInt(temperatureParameters.getNewHotPixelPercentage()));
        this.newHotPixelPercentage.setMajorTickSpacing(25);
        this.newHotPixelPercentage.setMinorTickSpacing(10);
        this.newHotPixelPercentage.setPaintTicks(true);
        this.newHotPixelPercentage.setPaintLabels(true);


        int rowCount = temperatureParameters.getCellsPonderation().length;
        int columnCount = temperatureParameters.getCellsPonderation()[0].length;
        this.cellsPonderation = new JTable(new DefaultTableModel(rowCount,columnCount));
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                this.cellsPonderation.setValueAt(temperatureParameters.getCellsPonderation()[i][j], i, j);
            }
        }

        this.cellsDivider = new JSlider(0, 1000, this.doublePercentageToInt(temperatureParameters.getCellsDivider()));
        this.cellsDivider.setMajorTickSpacing(250);
        this.cellsDivider.setMinorTickSpacing(100);
        this.cellsDivider.setPaintTicks(true);
        this.cellsDivider.setPaintLabels(true);

        this.fixAttenuationFactor = new JSlider(0, 1000, this.doublePercentageToInt(temperatureParameters.getFixAtenuationFactor()));
        this.fixAttenuationFactor.setMajorTickSpacing(250);
        this.fixAttenuationFactor.setMinorTickSpacing(100);
        this.fixAttenuationFactor.setPaintTicks(true);
        this.fixAttenuationFactor.setPaintLabels(true);


        this.bottonUpTemps = new JToggleButton("bottonUpTemps");
        this.bottonUpTemps.addActionListener(actionListener);
        addConfigurationToPane(this);
    }

public void addConfigurationToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        JLabel newColdPixelPercentageLabel = new JLabel("Porcentaje de pixeles fríos nuevos:");
        JLabel newHotPixelPercentageLabel = new JLabel("Porcentaje de pixeles calientes nuevos:");
        JLabel cellsPonderationLabel = new JLabel("Ponderación de celdas:");
        JLabel cellsDividerLabel = new JLabel("Divisor de celdas:");
        JLabel fixAttenuationFactorLabel = new JLabel("Factor de atenuación fijo:");
        JLabel bottonUpTempsLabel = new JLabel("Temperaturas de abajo hacia arriba:");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);

        panel.add(newColdPixelPercentageLabel, c);
        c.gridy++;
        panel.add(this.newColdPixelPercentage, c);

        c.gridy++;
        panel.add(newHotPixelPercentageLabel, c);
        c.gridy++;
        panel.add(this.newHotPixelPercentage, c);

        c.gridy++;
        panel.add(cellsPonderationLabel, c);
        c.gridy++;
        panel.add(this.cellsPonderation, c);

        c.gridy++;
        panel.add(cellsDividerLabel, c);
        c.gridy++;
        panel.add(this.cellsDivider, c);

        c.gridy++;
        panel.add(fixAttenuationFactorLabel, c);
        c.gridy++;
        panel.add(this.fixAttenuationFactor, c);

        c.gridy++;
        panel.add(bottonUpTempsLabel, c);
        c.gridy++;
        panel.add(this.bottonUpTemps, c);
    }

    private int doublePercentageToInt(double percentage){
        return (int) (percentage*100);
    }

    public JSlider getNewColdPixelPercentage() {
        return newColdPixelPercentage;
    }

    public void setNewColdPixelPercentage(JSlider newColdPixelPercentage) {
        this.newColdPixelPercentage = newColdPixelPercentage;
    }

    public JSlider getNewHotPixelPercentage() {
        return newHotPixelPercentage;
    }

    public void setNewHotPixelPercentage(JSlider newHotPixelPercentage) {
        this.newHotPixelPercentage = newHotPixelPercentage;
    }

    public JTable getCellsPonderation() {
        return cellsPonderation;
    }

    public void setCellsPonderation(JTable cellsPonderation) {
        this.cellsPonderation = cellsPonderation;
    }

    public JSlider getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(JSlider cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public JSlider getFixAttenuationFactor() {
        return fixAttenuationFactor;
    }

    public void setFixAttenuationFactor(JSlider fixAttenuationFactor) {
        this.fixAttenuationFactor = fixAttenuationFactor;
    }

    public JToggleButton getBottonUpTemps() {
        return bottonUpTemps;
    }

    public void setBottonUpTemps(JToggleButton bottonUpTemps) {
        this.bottonUpTemps = bottonUpTemps;
    }
}

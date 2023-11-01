import javax.swing.*;
import java.awt.*;

public class TemperatureConfiguration extends JPanel{
    private JSlider newCoolPixelPercentage;
    private JSlider newHotPixelPercentage;
    private JTable cellsPonderation;
    private JSlider cellsDivider;
    private JSlider fixAttenuationFactor;

    private JToggleButton bottonUpTemps;

    public TemperatureConfiguration() {
        this.setLayout(new GridBagLayout());
        this.newCoolPixelPercentage = new JSlider();
        this.newHotPixelPercentage = new JSlider();
        this.cellsPonderation = new JTable();
        this.bottonUpTemps = new JToggleButton();
    }

}

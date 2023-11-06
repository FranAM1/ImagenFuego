import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private AnimationControls animationControls;
    private GeneralParameters generalParameters;
    private PaletteConfiguration paletteConfiguration;

    private TemperatureConfiguration temperatureConfiguration;

    public ControlPanel(ActionListener actionListener, DTOGeneralParameters dtoGeneralParameters,
                        TemperatureParameters temperatureParameters, PaletteParameters paletteParameters) {
        this.setLayout(new GridBagLayout());
        this.animationControls = new AnimationControls(actionListener);
        this.generalParameters = new GeneralParameters(actionListener, dtoGeneralParameters);
        this.temperatureConfiguration = new TemperatureConfiguration(actionListener, temperatureParameters);
        this.paletteConfiguration = new PaletteConfiguration(actionListener, paletteParameters);
        addConfigurationToPane(this);
    }

    public void addConfigurationToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);

        panel.add(this.animationControls, c);

        c.gridy++;
        panel.add(this.generalParameters, c);

        c.gridx++;
        panel.add(this.temperatureConfiguration, c);

        c.gridx++;
        panel.add(this.paletteConfiguration, c);
    }

    public AnimationControls getAnimationControls() {
        return animationControls;
    }

    public void setAnimationControls(AnimationControls animationControls) {
        this.animationControls = animationControls;
    }

    public GeneralParameters getGeneralParameters() {
        return generalParameters;
    }

    public void setGeneralParameters(GeneralParameters generalParameters) {
        this.generalParameters = generalParameters;
    }

    public TemperatureConfiguration getTemperatureConfiguration() {
        return temperatureConfiguration;
    }

    public void setTemperatureConfiguration(TemperatureConfiguration temperatureConfiguration) {
        this.temperatureConfiguration = temperatureConfiguration;
    }
}

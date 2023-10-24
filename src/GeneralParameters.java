import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GeneralParameters extends JPanel{
    private JTextField fireWidth, fireHeight;

    private JTextField fireXPosition, fireYPosition;

    private JTextField calcFramesPerSecond, showFramesPerSecond;

    private Image backgroundImage;

    public GeneralParameters(ActionListener actionListener, DTOGeneralParameters dtoGeneralParameters) {
        this.setLayout(new GridBagLayout());
        this.fireWidth = new JTextField(Integer.toString(dtoGeneralParameters.getFireWidth()));
        this.fireHeight = new JTextField(Integer.toString(dtoGeneralParameters.getFireHeight()));
        this.fireXPosition = new JTextField(Integer.toString(dtoGeneralParameters.getFireXPosition()));
        this.fireYPosition = new JTextField(Integer.toString(dtoGeneralParameters.getFireYPosition()));
        this.calcFramesPerSecond = new JTextField("0");
        this.showFramesPerSecond = new JTextField("0");
        this.backgroundImage = null;
        addInputsToPane(this);
    }

    private void addInputsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        JLabel widthLabel = new JLabel("Ancho del fuego:");
        JLabel heightLabel = new JLabel("Altura del fuego:");
        JLabel xPositionLabel = new JLabel("Posición inicial X del fuego:");
        JLabel yPositionLabel = new JLabel("Posición inicial Y del fuego:");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);

        panel.add(widthLabel, c);
        c.gridy++;
        panel.add(this.fireWidth, c);

        c.gridy++;
        panel.add(heightLabel, c);
        c.gridy++;
        panel.add(this.fireHeight, c);

        c.gridy++;
        panel.add(xPositionLabel, c);
        c.gridy++;
        panel.add(this.fireXPosition, c);

        c.gridy++;
        panel.add(yPositionLabel, c);
        c.gridy++;
        panel.add(this.fireYPosition, c);
    }

    public JTextField getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(JTextField fireWidth) {
        this.fireWidth = fireWidth;
    }

    public JTextField getFireHeight() {
        return fireHeight;
    }

    public void setFireHeight(JTextField fireHeight) {
        this.fireHeight = fireHeight;
    }

    public JTextField getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(JTextField fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public JTextField getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(JTextField fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public JTextField getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(JTextField calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public JTextField getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(JTextField showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}

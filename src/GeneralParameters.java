import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class GeneralParameters extends JPanel{
    private JTextField fireWidth, fireHeight;

    private JTextField fireXPosition, fireYPosition;

    private JTextField calcFramesPerSecond, showFramesPerSecond;

    private JButton backgroundImageButton;

    private Image backgroundImage;

    private DTOGeneralParameters dtoGeneralParameters;

    public GeneralParameters(ActionListener actionListener, DTOGeneralParameters dtoGeneralParameters) {
        this.setLayout(new GridBagLayout());
        this.fireWidth = new JTextField(Integer.toString(dtoGeneralParameters.getFireWidth()));
        this.fireHeight = new JTextField(Integer.toString(dtoGeneralParameters.getFireHeight()));
        this.fireXPosition = new JTextField(Integer.toString(dtoGeneralParameters.getFireXPosition()));
        this.fireYPosition = new JTextField(Integer.toString(dtoGeneralParameters.getFireYPosition()));
        this.calcFramesPerSecond = new JTextField("0");
        this.showFramesPerSecond = new JTextField("0");
        this.backgroundImageButton = new JButton("backgroundImage");
        this.backgroundImageButton.addActionListener(actionListener);
        this.backgroundImage = dtoGeneralParameters.getBackgroundImage();
        this.dtoGeneralParameters = dtoGeneralParameters;
        addInputsToPane(this);
    }

    private void addInputsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        JLabel widthLabel = new JLabel("Ancho del fuego:");
        JLabel heightLabel = new JLabel("Altura del fuego:");
        JLabel xPositionLabel = new JLabel("Posición inicial X del fuego:");
        JLabel yPositionLabel = new JLabel("Posición inicial Y del fuego:");
        JLabel backgroundImageLabel = new JLabel("Imagen de fondo:");

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

        c.gridy++;
        panel.add(backgroundImageLabel, c);
        c.gridy++;
        panel.add(this.backgroundImageButton, c);

        c.gridy++;
        JLabel nameImageLabel = new JLabel("Nombre de la imagen: ");
        panel.add(nameImageLabel, c);
        c.gridy++;
        JLabel nameImage = new JLabel(this.dtoGeneralParameters.getImageName());
        panel.add(nameImage, c);

        c.gridy++;
        JLabel pathImageLabel = new JLabel("Ruta de la imagen: ");
        panel.add(pathImageLabel, c);
        c.gridy++;
        JLabel pathImage = new JLabel(this.dtoGeneralParameters.getImagePath());
        panel.add(pathImage, c);

        c.gridy++;
        JLabel imageResolutionLabel = new JLabel("Resolución de la imagen: ");
        panel.add(imageResolutionLabel, c);
        c.gridy++;
        JLabel imageResolution = new JLabel(backgroundImage.getWidth(null)+"x"+backgroundImage.getHeight(null));
        panel.add(imageResolution, c);
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

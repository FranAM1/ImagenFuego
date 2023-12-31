import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener {
    private Viewer viewer;
    private ControlPanel controlPanel;
    private DTOGeneralParameters dtoGeneralParameters;
    private TemperatureParameters temperatureParameters;
    private FireController fireController;

    public FireView(FireModel fireModel, DTOGeneralParameters dtoGeneralParameters,
                    FireController fireController, TemperatureParameters temperatureParameters,
                    PaletteParameters paletteParameters){
        this.viewer = new Viewer(700, 700, fireModel, dtoGeneralParameters);
        this.controlPanel = new ControlPanel(this, dtoGeneralParameters, temperatureParameters, paletteParameters);
        this.dtoGeneralParameters = dtoGeneralParameters;
        this.temperatureParameters = temperatureParameters;
        this.fireController = fireController;
        this.configureJFrame();
    }

    private void configureJFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
        this.addViewerToPane(this.getContentPane());
        this.addControlPanelToPane(this.getContentPane());
    }

    private void addControlPanelToPane(Container panel){
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(controlPanel, c);
    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(viewer, c);
    }

    private void stopAnimation() {
        this.viewer.paintBackground();
        this.viewer.getBs().show();
        this.viewer.getForegroundImg().getTemperatures().resetTemperatures();
        this.viewer.getForegroundImg().initAllTransparent();
    }

    private void updateDTO() {
            this.dtoGeneralParameters.setFireWidth(Integer.parseInt(
                    this.controlPanel.getGeneralParameters().getFireWidth().getText()));


            this.dtoGeneralParameters.setFireHeight(Integer.parseInt(
                    this.controlPanel.getGeneralParameters().getFireHeight().getText()));


            this.dtoGeneralParameters.setFireXPosition(Integer.parseInt(
                    this.controlPanel.getGeneralParameters().getFireXPosition().getText()));


            this.dtoGeneralParameters.setFireYPosition(Integer.parseInt(
                    this.controlPanel.getGeneralParameters().getFireYPosition().getText()));

            this.temperatureParameters.setNewColdPixelPercentage(
                    this.controlPanel.getTemperatureConfiguration().getNewColdPixelPercentage().getValue()/100.0);

            this.temperatureParameters.setNewHotPixelPercentage(
                    this.controlPanel.getTemperatureConfiguration().getNewHotPixelPercentage().getValue()/100.0);

            double[][] cellsPonderation = new double[2][3];

            for (int i = 0; i < this.temperatureParameters.getCellsPonderation().length; i++) {
                for (int j = 0; j < this.temperatureParameters.getCellsPonderation()[i].length; j++) {
                    cellsPonderation[i][j] =
                            Double.parseDouble(this.controlPanel.getTemperatureConfiguration().
                            getCellsPonderation().getValueAt(i, j).toString());
                }
            }

            this.temperatureParameters.setCellsPonderation(cellsPonderation);

            this.temperatureParameters.setCellsDivider(
                    this.controlPanel.getTemperatureConfiguration().getCellsDivider().getValue()/100.0);

            this.temperatureParameters.setFixAtenuationFactor(
                    this.controlPanel.getTemperatureConfiguration().getFixAttenuationFactor().getValue()/100.0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "playPause":
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage();
                break;
            case "apply":
                this.controlPanel.getAnimationControls().getPlayPause().setSelected(false);
                this.stopAnimation();
                this.updateDTO();
                this.fireController.updateValues();
                this.viewer.paintBackground();
                this.viewer.getBs().show();
                this.controlPanel.getGeneralParameters().updateImageInfo();
                break;
            case "stop":
                this.controlPanel.getAnimationControls().getPlayPause().setSelected(false);
                this.stopAnimation();
                break;
            case "backgroundImage":
                JFileChooser fileChooser = new JFileChooser();

                int response = fileChooser.showSaveDialog(null);

                if (response == JFileChooser.APPROVE_OPTION) {
                    //check if the file is an image
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    if (path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".jpeg")) {
                        try{
                            this.dtoGeneralParameters.setBackgroundImage(ImageIO.read(new File(path)));
                        }catch (Exception ex){
                            System.err.println("Error loading image. ");
                            System.err.println(ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Estension not supported");
                    }

                    File image = new File(path);
                    this.dtoGeneralParameters.setImageName(image.getName());
                    this.dtoGeneralParameters.setImagePath(image.getAbsolutePath());
                }

                break;
            case "bottonUpTemps":
                this.temperatureParameters.setBottonUpTemps(!this.temperatureParameters.getBottonUpTemps());
                System.out.println("bottonUpTemps: " + this.temperatureParameters.getBottonUpTemps());
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        //System.out.println("Frame hidden");
    }


    @Override
    public void componentMoved(ComponentEvent ce) {
        // System.out.println("Frame moved");
    }


    @Override
    public void componentResized(ComponentEvent ce) {
        // System.out.println("Frame resized");
    }


    @Override
    public void componentShown(ComponentEvent ce) {
        // System.out.println("Frame Shown");
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        int estado = itemEvent.getStateChange();
        if (estado == ItemEvent.SELECTED) {
        } else {
        }
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

}

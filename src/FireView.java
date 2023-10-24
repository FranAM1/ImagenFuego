import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener {
    Viewer viewer;
    ControlPanel controlPanel;
    DTOGeneralParameters dtoGeneralParameters;
    FireController fireController;

    public FireView(FireModel fireModel, DTOGeneralParameters dtoGeneralParameters, FireController fireController){
        this.viewer = new Viewer(700, 700, fireModel);
        this.controlPanel = new ControlPanel(this, dtoGeneralParameters);
        this.dtoGeneralParameters = dtoGeneralParameters;
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

    private void updateDTO(){
        try{
            this.dtoGeneralParameters.setFireWidth(Integer.parseInt(this.controlPanel.getGeneralParameters().getFireWidth().getText()));
        }catch (NumberFormatException e){
            this.dtoGeneralParameters.setFireWidth(0);
        }

        try{
            this.dtoGeneralParameters.setFireHeight(Integer.parseInt(this.controlPanel.getGeneralParameters().getFireHeight().getText()));
        }catch (NumberFormatException e){
            this.dtoGeneralParameters.setFireHeight(0);
        }

        try{
            this.dtoGeneralParameters.setFireXPosition(Integer.parseInt(this.controlPanel.getGeneralParameters().getFireXPosition().getText()));
        }catch (NumberFormatException e){
            this.dtoGeneralParameters.setFireXPosition(0);
        }

        try{
            this.dtoGeneralParameters.setFireYPosition(Integer.parseInt(this.controlPanel.getGeneralParameters().getFireYPosition().getText()));
        }catch (NumberFormatException e){
            this.dtoGeneralParameters.setFireYPosition(0);
        }


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
                break;
            case "stop":
                this.controlPanel.getAnimationControls().getPlayPause().setSelected(false);
                this.stopAnimation();
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
import javax.swing.*;
import java.awt.*;

public class FireView extends JFrame {
    Viewer viewer;
    ControlPanel controlPanel;

    public FireView(FireModel fireModel){
        this.viewer = new Viewer(700, 700, fireModel);
        this.controlPanel = new ControlPanel(viewer, 300, 405, 0, 0);
        this.configureJFrame();
        addViewerToPane(this.getContentPane());
        addButtonsToPane(this.getContentPane());
    }

    private void configureJFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this.controlPanel.getAnimationControls());
    }

    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();
        JToggleButton bPlayPause = this.controlPanel.getAnimationControls().getPlayPauseButton();
        JButton bReset = this.controlPanel.getAnimationControls().getResetButton();


        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;

        bPlayPause.addActionListener(this.controlPanel.getAnimationControls());
        panel.add(bPlayPause, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;

        bReset.addActionListener(this.controlPanel.getAnimationControls());
        panel.add(bReset, c);
    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 4;
        c.gridwidth = 1;

        panel.add(viewer, c);
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

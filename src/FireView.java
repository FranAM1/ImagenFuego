import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener {
    Viewer viewer;
    ControlPanel controlPanel;

    public FireView(FireModel fireModel){
        this.viewer = new Viewer(700, 700, fireModel);
        this.controlPanel = new ControlPanel(300, 405, 0, 0);
        this.configureJFrame();
        addViewerToPane(this.getContentPane());
        addButtonsToPane(this.getContentPane());
    }

    private void configureJFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
    }

    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();
        JToggleButton bPlayPause = this.controlPanel.getAnimationControls().getPlayPause();
        JButton bApply = this.controlPanel.getAnimationControls().getApply();
        JButton bStop = this.controlPanel.getAnimationControls().getStopButton();


        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;

        bPlayPause.addActionListener(this);
        panel.add(bPlayPause, c);

        c.gridy = 1;
        bApply.addActionListener(this);
        panel.add(bApply, c);

        c.gridy = 2;
        bStop.addActionListener(this);
        panel.add(bStop, c);
    }

    private void addInputsToPane() {
        GridBagConstraints c = new GridBagConstraints();
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

    private void stopAnimation() {
        this.viewer.paintBackground();
        this.viewer.getBs().show();
        this.viewer.getForegroundImg().getTemperatures().resetTemperatures();
        this.viewer.getForegroundImg().initAllTransparent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        System.out.println(str);
        switch (str) {
            case "playPause":
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage();
                break;
            case "apply":
                this.stopAnimation();
                break;
            case "stop":
                this.stopAnimation();
                this.controlPanel.getAnimationControls().getPlayPause().setSelected(false);
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

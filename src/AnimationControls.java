import javax.swing.*;
import java.awt.event.*;

public class AnimationControls implements ComponentListener, ActionListener, ItemListener {
    private JToggleButton playPauseButton;
    private JButton resetButton;
    private Viewer viewer;

    public AnimationControls(Viewer viewer) {
        this.viewer = viewer;
        this.playPauseButton = new JToggleButton("playPause");
        this.resetButton = new JButton("reset");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "playPause":
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage();
                break;
            case "reset":
                this.viewer.paintBackground();
                this.viewer.getBs().show();
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

    public JToggleButton getPlayPauseButton() {
        return playPauseButton;
    }

    public void setPlayPauseButton(JToggleButton playPauseButton) {
        this.playPauseButton = playPauseButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

}

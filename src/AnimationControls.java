import javax.swing.*;

public class AnimationControls{
    private JToggleButton playPause;
    private JButton apply;
    private JButton stopButton;

    public AnimationControls() {
        this.playPause = new JToggleButton("playPause");
        this.apply = new JButton("apply");
        this.stopButton = new JButton("stop");
    }

    public JToggleButton getPlayPause() {
        return playPause;
    }

    public void setPlayPause(JToggleButton playPause) {
        this.playPause = playPause;
    }

    public JButton getApply() {
        return apply;
    }

    public void setApply(JButton apply) {
        this.apply = apply;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }

}

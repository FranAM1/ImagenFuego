import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AnimationControls extends JPanel{
    private JToggleButton playPause;
    private JButton apply;
    private JButton stopButton;

    public AnimationControls(ActionListener actionListener) {
        this.setLayout(new GridBagLayout());
        this.playPause = new JToggleButton("playPause");
        this.apply = new JButton("apply");
        this.stopButton = new JButton("stop");
        addButtonsToPane(this, actionListener);
    }

    private void addButtonsToPane(Container panel, ActionListener actionListener) {
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

        this.playPause.addActionListener(actionListener);
        panel.add(this.playPause, c);

        c.gridy++;
        this.stopButton.addActionListener(actionListener);
        panel.add(this.stopButton, c);

        c.gridy++;
        this.apply.addActionListener(actionListener);
        panel.add(this.apply, c);
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class FireTask extends JFrame implements ComponentListener, ActionListener, ItemListener {
    private Viewer viewer;
    private JButton bForeground;
    private JButton bBackground;
    private JToggleButton tbPlay;
    private FireAnimation animation;

    public static void main(String[] args) {
        FireTask ft = new FireTask();

        ft.playAnimation();
    }

    public FireTask() {
        this.initClass();
        this.configureJFrame();
        this.addUIComponents();
        this.setVisible(true);
        this.pack();
    }

    public void playAnimation() {
        while (true) {
            if (this.tbPlay.isSelected()) {
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage();
            }
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    private void addUIComponents(){
        Container panel;

        panel = this.getContentPane();
        this.addViewerToPane(panel);
        this.addButtonsToPane(panel);

    }

    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;

        this.bForeground = new JButton("Mostrar Foreground");
        this.bForeground.addActionListener(this);
        panel.add(this.bForeground, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;

        this.bBackground = new JButton("Mostrar Background");
        this.bBackground.addActionListener(this);
        panel.add(this.bBackground, c);

        c.gridy = 2;
        this.tbPlay = new JToggleButton("Play");
        this.tbPlay.addActionListener(this);
        panel.add(this.tbPlay, c);
    }

    private void configureJFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
    }

    private void initClass(){
        int widthAnimation = 290;
        int heightAnimation = 150;
        ColorPalette palette = new ColorPalette(new ArrayList<ColorTarget>(){{
            add(new ColorTarget(150, new Color(250, 255, 255, 255)));
            add(new ColorTarget(130, new Color(255, 255, 200, 255)));
            add(new ColorTarget(112, new Color(235, 235, 40, 250)));
            add(new ColorTarget(72, new Color(200, 100, 0, 180)));
            add(new ColorTarget(60, new Color(155, 0, 0, 110)));
            add(new ColorTarget(55, new Color(0, 0, 0, 100)));
        }});

        Temperatures temperatures = new Temperatures(widthAnimation, heightAnimation, 0.25, 0.09);

        this.animation = new FireAnimation(widthAnimation, heightAnimation, 300, 405, temperatures, palette);
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

        this.viewer = new Viewer(700, 700, animation);
        panel.add(this.viewer, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Mostrar Foreground":
                this.viewer.paintForegroundImage();
                break;
            case "Mostrar Background":
                this.viewer.paintBackground();
                this.viewer.getBs().show();
                break;
            case "Play":
                this.viewer.paintBackground();
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
}
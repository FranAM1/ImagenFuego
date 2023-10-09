import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FireTask extends JFrame {
    private Viewer viewer;

    public FireTask() {
        this.configureJFrame();
        this.addUIComponents();
        this.setVisible(true);
        this.pack();
    }

    private void addUIComponents(){
        Container panel;

        panel = this.getContentPane();
        this.addViewerToPane(panel);

    }

    private void configureJFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addViewerToPane(Container panel) {
        ColorPalette palette = new ColorPalette(new ArrayList<ColorTarget>(){{
            add(new ColorTarget(250,new Color( 230, 200, 210, 225)));
            add(new ColorTarget(200,new Color( 180, 150, 175, 200)));
            add(new ColorTarget(150,new Color( 150, 100, 150, 175)));
            add(new ColorTarget(100,new Color( 100, 50, 100, 150)));
        }});

        this.viewer = new Viewer(700, 700, palette);
        panel.add(this.viewer);
    }

    public void run(){
    }

    public static void main(String[] args) {
        FireTask ft = new FireTask();
    }
}
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
            add(new ColorTarget(150, new Color(250, 255, 255, 255)));
            add(new ColorTarget(130, new Color(255, 255, 200, 255)));
            add(new ColorTarget(112, new Color(235, 235, 40, 250)));
            add(new ColorTarget(72, new Color(200, 100, 0, 180)));
            add(new ColorTarget(60, new Color(155, 0, 0, 110)));
            add(new ColorTarget(55, new Color(0, 0, 0, 100)));
        }});

        this.viewer = new Viewer(700, 700, palette);
        panel.add(this.viewer);
    }

    public static void main(String[] args) {
        FireTask ft = new FireTask();

        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ft.viewer.showNewFrame();
        }
    }
}
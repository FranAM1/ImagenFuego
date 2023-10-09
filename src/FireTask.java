import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FireTask extends JFrame {
    private Viewer viewer;
    private FireAnimation fa;

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
        this.viewer = new Viewer(700, 700);
        panel.add(this.viewer);
    }

    public void run(){
        this.fa.run();
    }

    public static void main(String[] args) {
        FireTask ft = new FireTask();



//        int width = 10;
//        int height = 4;
//        double coldPoints = 0.1;
//        double sparks = 0.3;
//
//        Temperatures test = new Temperatures(width, height, coldPoints, sparks);
//
//        test.next();
//
//        test.printArray();
//
//
//        ArrayList<ColorTarget> colorsTargets = new ArrayList<>();
//
//        colorsTargets.add(new ColorTarget(250,new Color( 230, 200, 210, 225)));
//        colorsTargets.add(new ColorTarget(200,new Color( 180, 150, 175, 200)));
//        colorsTargets.add(new ColorTarget(150,new Color( 150, 100, 150, 175)));
//        colorsTargets.add(new ColorTarget(100,new Color( 100, 50, 100, 150)));
//
//
//        ColorPalette palette = new ColorPalette(colorsTargets);
//
//
//        palette.calc();
//
//       for(int i = 0; i < palette.getColorsPalette().length; i++) {
//           System.out.println("Posicion "+i+":"+Arrays.toString(palette.getColorsPalette()[i]));
//       }



    }
}
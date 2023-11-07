import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;


public class PaletteConfiguration extends JPanel {

    JScrollPane palette;

    private JTextField temperaturas;

    private JColorChooser colorChooser;



    public PaletteConfiguration(ActionListener actionListener, PaletteParameters paletteParameters) {
        this.setLayout(new GridBagLayout());

        // CONFIGURACION DEL JTABLE DE LOS COLORES
        int rowCount = paletteParameters.getColorsTargets().size();

        Object[][] data = new Object[rowCount][2];

        String[] columnNames = {"Temperatura", "RGBA", "Color"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        for (int i = 0; i < rowCount;i++){
            table.setValueAt(paletteParameters.getColorsTargets().get(i).getTemperature(), i, 0);

            int red = paletteParameters.getColorsTargets().get(i).getColor().getRed();
            int green = paletteParameters.getColorsTargets().get(i).getColor().getGreen();
            int blue = paletteParameters.getColorsTargets().get(i).getColor().getBlue();
            int alpha = paletteParameters.getColorsTargets().get(i).getColor().getAlpha();
            table.setValueAt(red+" | "+green+" | "+blue+" | "+alpha, i, 1);



            table.setValueAt("#"+String.format("%02x%02x%02x", red, green, blue), i, 2);
        }

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (col == 2) {
                    Color color = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK);
                    if (color != null) {
                        table.setValueAt(color.getRed()+" | "+color.getGreen()+" | "+color.getBlue()+" | "+color.getBlue(), row, 1);

                        table.setValueAt("#"+String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue()), row, col);
                    }
                }
            }
        });

        this.palette = new JScrollPane(table);
        this.palette.setPreferredSize(new Dimension(420, 100));

        // CONFIGURACION DEL TEXTFIELD DE LA TEMEPERATURA
        this.temperaturas = new JTextField("0");

        //CONFIGURACION DEL COLORCHOOSER
        this.colorChooser = new JColorChooser();



        this.addPaletteToPane(this);
    }


    private void addPaletteToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        JLabel temperaturasLabel = new JLabel("Valor de la temperatura:");
        JLabel colorChooserLabel = new JLabel("Color:");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);

        panel.add(temperaturasLabel, c);
        c.gridy++;
        panel.add(temperaturas, c);

        c.gridy++;
        panel.add(colorChooserLabel, c);
//        c.gridy++;
//        panel.add(colorChooser, c);

        c.gridy++;
        panel.add(palette, c);
    }

    public JScrollPane getPalette() {
        return palette;
    }

    public void setPalette(JScrollPane palette) {
        this.palette = palette;
    }

}

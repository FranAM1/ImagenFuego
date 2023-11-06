import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaletteConfiguration extends JPanel {

    JScrollPane palette;

    private JTextField temperaturas;



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

        }

        this.palette = new JScrollPane(table);
        this.palette.setPreferredSize(new Dimension(420, 100));

        // CONFIGURACION DE  DEL TEXTFIELD DE LA TEMEPERATURA
        this.temperaturas = new JTextField("0");



        this.addPaletteToPane(this);
    }


    private void addPaletteToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        JLabel temperaturasLabel = new JLabel("Valor de la temperatura:");

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
        panel.add(palette, c);
    }

    public JScrollPane getPalette() {
        return palette;
    }

    public void setPalette(JScrollPane palette) {
        this.palette = palette;
    }

}

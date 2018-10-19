package BL;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class KniffelTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        KniffelEntry k = (KniffelEntry) value;
        JCheckBox jc = new JCheckBox();
        jc.setOpaque(true);
        JLabel label = new JLabel();
        label.setOpaque(true);

        switch (column) {
            case 0:
                label.setText(k.getName());
                return label;
            case 1:
                jc.setSelected(k.isSelected());
                return jc;
            case 2:
                label.setText("" + k.getPoints());
                return label;
        }
        return label;
    }

}
 
package Dice;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DiceTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImageIcon[] il = {new ImageIcon(), new ImageIcon(), new ImageIcon(), new ImageIcon(), new ImageIcon()};
        RowEntry e = (RowEntry) value;
        boolean[] bl = {false, false, false, false, false};
        try {
            il = e.getImages();
            bl = e.getSel();
        } catch (Exception x) {
        }

        JLabel label = new JLabel();
        label.setOpaque(true);
        //System.out.println("cell render: " + column);

        switch (column) {
            case 0:
                if (bl[0]) {
                    label.setBackground(Color.red);
                } else {
                    label.setBackground(Color.white);
                }
                label.setIcon((Icon) il[0]);
                break;
            case 1:
                if (bl[1]) {
                    label.setBackground(Color.red);
                } else {
                    label.setBackground(Color.white);
                }
                label.setIcon((Icon) il[1]);
                break;
            case 2:
                if (bl[2]) {
                    label.setBackground(Color.red);
                } else {
                    label.setBackground(Color.white);
                }
                label.setIcon((Icon) il[2]);
                break;
            case 3:
                if (bl[3]) {
                    label.setBackground(Color.red);
                } else {
                    label.setBackground(Color.white);
                }
                label.setIcon((Icon) il[3]);
                break;
            case 4:
                if (bl[4]) {
                    label.setBackground(Color.red);
                } else {
                    label.setBackground(Color.white);
                }
                label.setIcon((Icon) il[4]);
        }
        return label;
    }

}

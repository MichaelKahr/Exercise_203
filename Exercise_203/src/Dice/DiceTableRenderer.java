package Dice;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DiceTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImageIcon[]list = (ImageIcon[])value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        switch(column){
            case 0: label.setIcon((Icon)list[0]);break;
            case 1: label.setIcon((Icon)list[1]);break;
            case 2: label.setIcon((Icon)list[2]);break;
            case 3: label.setIcon((Icon)list[3]);break;
            case 4: label.setIcon((Icon)list[4]);break;
            case 5: label.setIcon((Icon)list[5]);break;
            
        }
        return label;
    }

}

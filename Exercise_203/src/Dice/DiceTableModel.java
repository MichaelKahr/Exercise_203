package Dice;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class DiceTableModel extends AbstractTableModel {
    
    private LinkedList<ImageIcon[]>images = new LinkedList<>();
    
    public void add(ImageIcon[] i){
        images.add(i);
        fireTableRowsInserted(images.size()-1, images.size()-1);
    }
    
    @Override
    public int getRowCount() {
        return images.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return images.get(rowIndex);
    }



}

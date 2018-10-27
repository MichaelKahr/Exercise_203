package Dice;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class DiceTableModel extends AbstractTableModel {

    private LinkedList<RowEntry> images = new LinkedList<>();

    public void add(RowEntry r) {
        images.add(r);
        fireTableRowsInserted(images.size() - 1, images.size() - 1);
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

    public void changeState(int r, int c) {
        if (images.get(r).getSel()[c]) {
            images.get(r).setSpecBool(c, false);
        } else {
            images.get(r).setSpecBool(c, true);
        }
        try {
            fireTableCellUpdated(r, c);
        } catch (Exception ex) {

        }
        System.out.println(images.get(c).getSel()[c]);
    }

    public LinkedList<RowEntry> getImages() {
        return images;
    }

    public void mix() {
        images.get(0).shuffle();
        images.get(0).getNum();
        fireTableRowsUpdated(0, 0);
    }

}

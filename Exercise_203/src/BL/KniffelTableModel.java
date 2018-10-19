package BL;

import Dice.DiceTableModel;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class KniffelTableModel extends AbstractTableModel {

    private LinkedList<KniffelEntry> entries = new LinkedList();
    private static String[] colNames = {"Spiel", "Wahl", "Punkte"};

    public void add(KniffelEntry k) {
        entries.add(k);
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    public void changeState(int i) {
        if (entries.get(i).isSelected()) {
            entries.get(i).setSelected(false);
        } else {
            entries.get(i).setSelected(true);
        }
        fireTableCellUpdated(i, 1);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return entries.get(rowIndex);
    }
}

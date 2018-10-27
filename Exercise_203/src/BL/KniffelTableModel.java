package BL;

import Dice.RowEntry;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class KniffelTableModel extends AbstractTableModel {

    private LinkedList<KniffelEntry> entries = new LinkedList();
    private static String[] colNames = {"Spiel", "Wahl", "Punkte"};
    private int oPunkte = 0;
    private int oBonus = 0;
    private int uPunkte = 0;
    private int gesPunkte = 0;

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

    public int getoPunkte() {
        return oPunkte;
    }

    public int getoBonus() {
        return oBonus;
    }

    public int getuPunkte() {
        return uPunkte;
    }

    public int getGesPunkte() {
        return gesPunkte;
    }

    public void changeState(int i) {
        if (entries.get(i).isSelected()) {
            entries.get(i).setSelected(false);
            points();
        } else {
            entries.get(i).setSelected(true);
            points();
        }
        fireTableCellUpdated(i, 1);
    }

    public void resPunkte() {
        oBonus = 0;
        oPunkte = 0;
        uPunkte = 0;
        gesPunkte = 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return entries.get(rowIndex);
    }

    public void points() {
        int[] dices = RowEntry.numbers;
        resPunkte();
        int r;
        for (KniffelEntry e : entries) {
            if (e.isSelected()) {
                switch (e.getName()) {
                    case "Nur Einser":
                        r = numResults(dices, 1);
                        e.setPoints(r);
                        oPunkte += r;
                        break;
                    case "Nur Zweier":
                        r = numResults(dices, 2);
                        e.setPoints(r);
                        oPunkte += r;
                        break;
                    case "Nur Dreier":
                        r = numResults(dices, 3);
                        e.setPoints(r);
                        oPunkte += r;
                        break;
                    case "Nur Vierer":
                        r = numResults(dices, 4);
                        e.setPoints(r);
                        oPunkte += r;
                        break;
                    case "Nur Fünfer":
                        r = numResults(dices, 5);
                        e.setPoints(r);
                        oPunkte += r;
                        break;
                    case "Nur Sechser":
                        r = numResults(dices, 6);
                        e.setPoints(r);
                        oPunkte += r;
                        break;
                    case "Full House":
                        r = fHouse(dices);
                        e.setPoints(r);
                        uPunkte+=r;
                        break;
                    case "Strasse klein":
                        r = kStr(dices);
                        e.setPoints(r);
                        uPunkte += r;
                        break;
                    case "Strasse groß":
                        r = gStr(dices);
                        e.setPoints(r);
                        uPunkte += r;
                        break;
                    case "Kniffel":
                        r = kniffel(dices);
                        e.setPoints(r);
                        uPunkte += r;
                        break;
                }
            } else {
                e.setPoints(0);
            }
        }
        gesPunkte = oPunkte + oBonus + uPunkte;
        fireTableDataChanged();
    }

    private int numResults(int[] dices, int num) {
        int count = 0;
        for (int val : dices) {
            if (val == num) {
                count++;
            }
        }
        return count * num;
    }

    private int kniffel(int[] dices) {
        if (dices[0] == dices[1] && (dices[2] == dices[3] && (dices[4] == dices[1]))) {
            return 50;
        } else {
            return 0;
        }
    }

    private int pasch(int[] dices, int c) {
        boolean p = false;
        int pa = 0;
        for (int i = 0; i < dices.length; i++) {
            if (dices[i] == dices[i + 1]) {
                p = true;
                pa++;
                if (pa == c) {
                    break;
                }
            } else {
                p = false;
            }
        }
    }

    private int kStr(int[] dices) {
        if (dices[0] + 3 == dices[1] + 2 && dices[2] + 1 == dices[3]) {
            return 30;
        }
        if (dices[1] + 3 == dices[2] + 2 && dices[3] + 1 == dices[4]) {
            return 30;
        }
        return 0;
    }

    private int gStr(int[] dices) {
        if (dices[0] + 4 == dices[1] + 3 && dices[2] + 2 == dices[3] + 1 && dices[3] + 1 == dices[4]) {
            return 40;
        }
        return 0;
    }

    private int fHouse(int[] dices) {
        int p1 = 0;
        int c1 = 0;
        int p2 = 0;
        int c2 = 0;

        p1 = dices[0];
        for (int dice : dices) {
            if (dice == p1) {
                c1++;
            }
        }
        //System.out.println(c1);
        for (int dice : dices) {
            if(dice!=p1){
                p2=dice;
                break;
            }
        }
        for (int dice : dices) {
            if(dice==p2){
                c2++;
            }
        }
        //System.out.println(c2);
        if((c1==3&&c2==2)||(c1==2&&c2==3)){
            return 25;
        }
        return 0;
    }
}

package BL;

public class KniffelEntry {

    private String name;
    private boolean selected;
    private int points;

    public KniffelEntry(String name, boolean selected, int points) {
        this.name = name;
        this.selected = selected;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}

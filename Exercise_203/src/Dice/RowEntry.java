package Dice;

import java.util.Random;
import javax.swing.ImageIcon;

public class RowEntry {

    private ImageIcon[] images;
    private boolean[] sel;
    private ImageIcon[] timages = {new javax.swing.ImageIcon(getClass().getResource("/res/Alea_1.png")),
        new javax.swing.ImageIcon(getClass().getResource("/res/Alea_2.png")),
        new javax.swing.ImageIcon(getClass().getResource("/res/Alea_3.png")),
        new javax.swing.ImageIcon(getClass().getResource("/res/Alea_4.png")),
        new javax.swing.ImageIcon(getClass().getResource("/res/Alea_5.png")),
        new javax.swing.ImageIcon(getClass().getResource("/res/Alea_6.png"))};
    public static int[] numbers = {0, 0, 0, 0, 0};

    public RowEntry(ImageIcon[] images, boolean[] sel) {
        this.images = images;
        this.sel = sel;
        shuffle();
        //System.out.println(timages[1].getDescription().substring(timages[1].getDescription().length()-5, timages[1].getDescription().length()-4));
        //System.out.println(images[1].getDescription().substring(images[1].getDescription().length()-5, images[1].getDescription().length()-4));
        getNum();

    }

    public ImageIcon[] getImages() {
        return images;
    }

    public boolean[] getSel() {
        return sel;
    }

    public void setImages(ImageIcon[] images) {
        this.images = images;
    }

    public void setSel(boolean[] sel) {
        this.sel = sel;
    }

    public void setSpecBool(int pos, boolean value) {
        sel[pos] = value;
    }

    public void shuffle() {
        for (int i = 0; i < 5; i++) {
            if (sel[i] == false) {
                images[i] = timages[new Random().nextInt(6)];
            }
        }
    }

    public void getNum() {
        for (int i = 0; i < images.length - 1; i++) {
            //System.out.println(images[i].getDescription().substring(images[i].getDescription().length()-5, images[i].getDescription().length()-4));
            numbers[i] = Integer.parseInt(images[i].getDescription().substring(images[i].getDescription().length() - 5, images[i].getDescription().length() - 4));
            //System.out.println(numbers[i]);
        }
    }

}

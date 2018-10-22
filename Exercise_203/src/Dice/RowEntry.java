package Dice;

import java.util.Random;
import javax.swing.ImageIcon;

public class RowEntry {

    private ImageIcon[] images;
    private boolean[] sel;
    private ImageIcon[] timages = {new ImageIcon(), new ImageIcon(), new ImageIcon(), new ImageIcon(), new ImageIcon()};
    private int imgcount;
    private int scount;

    public RowEntry(ImageIcon[] images, boolean[] sel) {
        this.images = images;
        this.sel = sel;
        timages = this.images;
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
//        imgcount = 0;
//        for (int i = 0; i < images.length - 1; i++) {
//            if (sel[i] == false) {
//                timages[imgcount] = images[i];
//                imgcount++;
//            }
//        }
//        Random rnd = new Random();
//        for (int i = timages.length - 1; i > 0; i--) {
//            int index = rnd.nextInt(i + 1);
//            // Simple swap
//            ImageIcon a = timages[index];
//            timages[index] = timages[i];
//            timages[i] = a;
//        }
//        scount=0;
//        for(int i = 0; i<images.length-1;i++){
//            if(sel[i]==false){
//                images[i]=timages[scount];
//                scount++;
//            }
//        }
//        
//        System.out.println(imgcount);
        for (int i = 0; i < images.length - 1; i++) {
            if (sel[i] == false) {
                images[i] = timages[new Random().nextInt(6)];
            }
        }
    }

}

package lõbustuspargi.simulaator;

import java.util.ArrayList;
import java.util.List;

public class Külastaja {
    private List<String> külastuseKirjeldused;
    private int vanus;
    private double kulud;

    public Külastaja(int vanus) {
        this.vanus = vanus;
        külastuseKirjeldused = new ArrayList<String>();
    }
    public void lisaKirjeldus(String inputString) {
        this.külastuseKirjeldused.add(inputString);
    }
    public List<String> kõikKirjeldused() {
        return this.külastuseKirjeldused;
    }
    public int getVanus() {
        return this.vanus;
    }
    public void lisaKulu(double kulu) {
        this.kulud += kulu;
    }
    public double kuludeSumma() {
        return this.kulud;
    }
}

package lõbustuspargi.simulaator;

public class LõbustavKloun implements Lõbustus {
    private Kloun kloun;
    public LõbustavKloun(Kloun kloun) {
        this.kloun = kloun;
    }
    public void lõbusta(Külastaja külastajaObject) {
        kloun.esine(külastajaObject);
    }
}
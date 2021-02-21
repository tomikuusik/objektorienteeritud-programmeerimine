package lõbustuspargi.simulaator;

public class TasulineLõbustus implements Lõbustus{
    private double hind;
    private Lõbustus delegaat;
    public TasulineLõbustus(double hind, Lõbustus delegaat) {
        this.hind = hind;
        this.delegaat = delegaat;
    }
    public void lõbusta(Külastaja külastajaObject) {
        delegaat.lõbusta(külastajaObject);
        külastajaObject.lisaKulu(hind);
        külastajaObject.lisaKirjeldus("tasusin külastuse eest " + hind);
    }
}

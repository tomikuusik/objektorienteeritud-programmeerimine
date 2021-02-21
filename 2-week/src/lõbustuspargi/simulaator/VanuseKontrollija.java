package lõbustuspargi.simulaator;

public class VanuseKontrollija implements Lõbustus {
    private int nõutudVanus;
    private Lõbustus delegaat;
    public VanuseKontrollija(int nõutudVanus,Lõbustus delegaat) {
        this.nõutudVanus = nõutudVanus;
        this.delegaat = delegaat;
    }
    public void lõbusta(Külastaja külastajaObject) {
        if (külastajaObject.getVanus() < nõutudVanus) {
            külastajaObject.lisaKirjeldus("külastaja ei läbinud vanusekontrolli");
        }
        else {
            delegaat.lõbusta(külastajaObject);
        }
    }
}

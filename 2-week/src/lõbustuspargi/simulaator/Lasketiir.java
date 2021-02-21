package lõbustuspargi.simulaator;

public class Lasketiir implements Lõbustus {
    public void lõbusta(Külastaja külastajaObject) {
        int randomNumber = (int)(Math.random()*20);
        külastajaObject.lisaKirjeldus("Tabasin lasketiirus " + randomNumber + " sihtmärki");
    }
}

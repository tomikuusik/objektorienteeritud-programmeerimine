package lõbustuspargi.simulaator;

import java.util.List;

public class Lõbustuspark {
    private List<Lõbustus> lõbustused;
    public Lõbustuspark(List<Lõbustus> lõbustusList) {
        this.lõbustused = lõbustusList;
    }
    public void alustaSeiklust(Külastaja külastajaObjekt) {
        System.out.println("alustan seiklust");
        for (Lõbustus lõbustus : lõbustused) {
            lõbustus.lõbusta(külastajaObjekt);
            System.out.println("Tehtud kulutused: " + külastajaObjekt.kuludeSumma());
        }
        System.out.println(külastajaObjekt.kõikKirjeldused());
    }
}

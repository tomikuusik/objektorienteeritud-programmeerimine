package lõbustuspargi.simulaator;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Vaateratas vaateratas1 = new Vaateratas();
        Lasketiir lasketiir1 = new Lasketiir();
        Kloun kloun1 = new Kloun("pennywise");
        Külastaja külastaja1 = new Külastaja(9);
        Külastaja külastaja2 = new Külastaja(11);
        TasulineLõbustus tasulinelõbustus1 = new TasulineLõbustus(2.25,vaateratas1);

        TasulineLõbustus tasulineLasketiir = new TasulineLõbustus(1.5, lasketiir1);
        VanuseKontrollija kontrollija1 = new VanuseKontrollija(10, tasulineLasketiir);
        /*
        Hetkel võetakse külaliselt raha ja siis kontrollitakse vanust
        Kui TasulineLõbustus ja VanuseKontrollija delegatsioonid ära vahetada siis toimuks asi teistpidi ehk
        Alguses kontrollitakse vanust ning kui see klapib siis võetakse raha
         */

        Lõbustuspark lõbustuspark1 = new Lõbustuspark(new ArrayList<Lõbustus>(Arrays.asList(tasulinelõbustus1, kontrollija1, new LõbustavKloun(kloun1))));
        lõbustuspark1.alustaSeiklust(külastaja1);
        lõbustuspark1.alustaSeiklust(külastaja2);
    }
}

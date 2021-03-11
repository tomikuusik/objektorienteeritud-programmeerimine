package telekanalid;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Erinevad kanalid mida saab tellida
        TVStation nationalNews = new TVStation(Arrays.asList("USA vaevub koroonariisis", "Põhja-Korea elukvaliteet on maailma kõrgeim", "Põhja-Korea kosmonaudid maandusid Päikesel"));
        TVStation foxNews = new TVStation(Arrays.asList("Trump protesteerib valimistulemusi", "Põhja-Korea SKP on vabalanguses", "Hiina eitab vähemuste represseerimist", "Euroopa vaktsineerimisprogramm liigub oodatavast aeglasemalt"));
        PirateStation pirateNews = new PirateStation();

        // Erinevate inimeste telekad
        TV tv1 = new TV("Kim Jong-un");
        TV tv2 = new TV("Kim Yong-nam");
        TV tv3 = new TV("Pak Pong-ju");

        // Kanalid mida piraatkanal kuulab
        nationalNews.subscribe(pirateNews);
        foxNews.subscribe(pirateNews);

        // Kanalid mida Kim Jong-un kuulab
        nationalNews.subscribe(tv1);
        foxNews.subscribe(tv1);

        // Kanalid mida Kim Yong-nam kuulab
        nationalNews.subscribe(tv2);

        // Kanalid mida Pak Pong-ju kuulab
        pirateNews.subscribe(tv3);

        // Väljundi algus
        System.out.println("Programmi väljund:");
        System.out.println("-".repeat(30));

        nationalNews.sendNews();
        foxNews.sendNews();

        System.out.println("-".repeat(30));
        System.out.println("Tomi Theodor Kuusik");
    }
}

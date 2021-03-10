package paralleelarvutused;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();

        Tulemused tulemused = new Tulemused(args.length);
        tulemused.addNimedQueue(Arrays.asList(args));

        Paralleelarvutused arvutaja = new Paralleelarvutused(tulemused);
        for (int i = 0; i < cores; i++) {
            Thread lõim = new Thread(arvutaja);
            lõim.start();
        }
        while (!tulemused.isFinished()) {
            continue;
        }
        System.out.println("Kõigi arvude summa on: " + tulemused.getSum());

        Object[] biggestPair = tulemused.getBiggest();
        System.out.print("Suurim number on: " + biggestPair[0]);
        System.out.println(", failist: " + biggestPair[1]);

        System.out.println("Kõige väiksema arvude summaga fail: " + tulemused.getSmallestFileName());

    }
}

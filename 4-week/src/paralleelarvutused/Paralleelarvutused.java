package paralleelarvutused;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Paralleelarvutused implements Runnable{
    Tulemused lõimeTulemused;
    public Paralleelarvutused (Tulemused lõimeTulemused) {
        this.lõimeTulemused = lõimeTulemused;
    }
    public void run () {
        while (!lõimeTulemused.nimedQueue.isEmpty()) {
            try {
                Object[] outputTriple = new Object[3];
                String currentFile = lõimeTulemused.nimedQueue.take();
                outputTriple[0] = currentFile;
                // Tuleb ära muuta vastavalt sellele kus failid on
                File file = new File("4-week/resources/sisendfailid/" + currentFile);
                Scanner fileScanner = new Scanner(file);
                BigInteger biggest = new BigInteger("0");
                BigInteger sumOfAll = new BigInteger("0");
                while (fileScanner.hasNext()) {
                    BigInteger currentInt = new BigInteger(fileScanner.next());
                    sumOfAll = sumOfAll.add(currentInt);
                    if (currentInt.compareTo(biggest) > 0) {
                        biggest = currentInt;
                    }
                    //System.out.println(currentInt);
                }
                outputTriple[1] = biggest;
                outputTriple[2] = sumOfAll;
                //lõimeTulemused.töödeldudQueue.add(outputTriple);
                lõimeTulemused.addTöödeldudQueue(outputTriple);
            }
            catch (InterruptedException | FileNotFoundException e) {
                System.out.println(e.toString());
            }
        }
    }
}

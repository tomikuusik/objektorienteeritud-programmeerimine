package paralleelarvutused;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class TeeArvud{
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            String path = "/home/tomi/Tresors/root/edu/university/objektorienteeritud-programmeerimine/4-week/resources/sisendfailid/" + i + ".txt";
            FileOutputStream output = new FileOutputStream(path);
            for (int j = 0; j < random.nextInt(21); j++) {
                int outInt = random.nextInt();
                String outData = outInt + " ";
                byte[] stringBytes = outData.getBytes(StandardCharsets.UTF_8);
                System.out.println(outInt);
                output.write(stringBytes);
            }
        }
    }
}

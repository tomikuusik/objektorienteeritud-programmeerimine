package failipuu.läbimine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailiTest {
    public static void main(String[] args) throws Exception{
        Path kaustanimi = Path.of(args[0]);
        if (Files.isDirectory(kaustanimi)) {
            FailiVaatleja vaatleja = new FailiVaatleja();
            NimeVõrdleja minuVõrdleja = new NimeVõrdleja();
            Files.walkFileTree(kaustanimi, vaatleja);
            List<String> vaatlejaArray = vaatleja.getFailiNimed();
            //System.out.println(vaatlejaArray);
            Collections.sort(vaatlejaArray);
            System.out.println("A->Z sorteeritud : " + vaatlejaArray);
            Collections.sort(vaatlejaArray, minuVõrdleja);
            System.out.println("Z->A sorteeritud : " + vaatlejaArray);
        }
        else {
            throw new Exception("Tegemist pole kaustaga");
        }
        }
}

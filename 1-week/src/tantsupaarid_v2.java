import java.lang.reflect.Array;
import java.util.Arrays;

public class tantsupaarid_v2 {
    public static void main(String[] args) {
        int poiste_arv = Integer.parseInt(args[0]);
        int[] poiste_pikkused = new int[poiste_arv];

        int tüdrukute_arv = Integer.parseInt(args[1 + poiste_arv]);
        int[] tüdrukute_pikkused = new int[tüdrukute_arv];

        for (int i = 1; i <= poiste_arv; i++) {
            poiste_pikkused[i - 1] = Integer.parseInt(args[i]);
        }
        for (int i = 1; i <= tüdrukute_arv; i++) {
            tüdrukute_pikkused[i - 1] = Integer.parseInt(args[poiste_arv + i + 1]);
        }
        int[][] tantsupaarid = combine(poiste_pikkused, tüdrukute_pikkused);
        System.out.printf(Arrays.deepToString(tantsupaarid));
    }
    static int[][] combine(int[] poiste_pikkused, int[] tüdrukute_pikkused) {
        Arrays.sort(poiste_pikkused);
        Arrays.sort(tüdrukute_pikkused);
        if (poiste_pikkused.length == tüdrukute_pikkused.length) {
            int[][] tantsupaarid = new int[poiste_pikkused.length][2];
            for (int i = 0; i < poiste_pikkused.length; i++) {
                tantsupaarid[i][0] = poiste_pikkused[poiste_pikkused.length - i - 1];
                tantsupaarid[i][1] = tüdrukute_pikkused[tüdrukute_pikkused.length - i - 1];
            }
            return tantsupaarid;
        } else {
            int korduste_arv;
            if (poiste_pikkused.length > tüdrukute_pikkused.length) {
                korduste_arv = tüdrukute_pikkused.length;
            } else {
                korduste_arv = poiste_pikkused.length;
            }
            int[][] tantsupaarid = new int[korduste_arv][2];
            for (int i = 0; i < korduste_arv; i++){
                tantsupaarid[i][0] = poiste_pikkused[korduste_arv - i - 1];
                tantsupaarid[i][1] = tüdrukute_pikkused[korduste_arv - i - 1];
            }
            return tantsupaarid;
        }
    }
}

package failipuu.läbimine;

import java.util.Comparator;

public class NimeVõrdleja implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int iterationLength =Math.min(o1.length(), o2.length());
        for (int i = 0; i < iterationLength; i++) {
            int diffChar = o1.charAt(i) - o2.charAt(i);
            if (diffChar == 0) {
                continue;
            }
            else if (diffChar > 0) {
                return  -1;
            }
            else {
                return 1;
            }
        }
        if (o1.length() == o2.length()) {
            return 0;
        }
        else if (o1.length() > o2.length()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

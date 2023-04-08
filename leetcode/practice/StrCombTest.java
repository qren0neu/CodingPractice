package leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class StrCombTest {
    public String largestNumber(int[] num) {
        StringBuilder sb = new StringBuilder();
        String[] numstr = new String[num.length];
        int maxlen = 0;
        for (int i = 0; i < num.length; i++) {
            // transfer into string
            numstr[i] = num[i] + "";
            // get the maxLength
            maxlen = Math.max(numstr[i].length(), maxlen);
        }
        for (int ii = 0; ii < maxlen; ii++) {
            final int i = ii;
            Arrays.sort(numstr, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // sort inside, get largest
                    double d1 = 0.0;
                    double d2 = 0.0;
                    if (i >= s1.length()) {
                        char c1 = s1.charAt(s1.length() - 1);
                        d1 = c1 + 0.5;
                    } else {
                        d1 = s1.charAt(i);
                    }
                    if (i >= s2.length()) {
                        char c2 = s2.charAt(s1.length() - 1);
                        d2 = c2 + 0.5;
                    } else {
                        d2 = s2.charAt(i);
                    }
                    return (int) Math.ceil(d1 - d2);
                }
            });
        }
        for (String s : numstr) {
            sb.append(s);
        }
        return sb.toString();
    }
}

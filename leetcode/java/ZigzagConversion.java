package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || len == 1 || numRows >= len) {
            return s;
        }
        List<StringBuilder> ll = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ll.add(new StringBuilder());
        }
        int maxRow = numRows - 1;
        for (int i = 0; i < len; i++) {
            int times = i / maxRow;
            int currentRow;
            if (times % 2 != 0) {
                currentRow = ((times + 1) * maxRow) - i;
            } else {
                currentRow = i % maxRow;
            }
            ll.get(currentRow).append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(ll.get(i));
        }
        return sb.toString();
    }
}

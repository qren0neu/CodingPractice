package leetcode.java;

import java.util.Comparator;
import java.util.TreeSet;

public class KWeakedRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int v1 = Integer.parseInt(o1.split("\\|")[1]);
                int v2 = Integer.parseInt(o2.split("\\|")[1]);
                int com = v1 - v2;
                if (com == 0) {
                    int k1 = Integer.parseInt(o1.split("\\|")[0]);
                    int k2 = Integer.parseInt(o2.split("\\|")[0]);
                    return k1 - k2;
                }
                return com;
            }
        });
        int m = mat.length;
        for (int i = 0; i < m; i++) {
            int[] lineM = mat[i];
            int countN = 0;
            for (int valueN : lineM) {
                if (valueN == 1) {
                    countN++;
                } else {
                    break;
                }
            }
            treeSet.add(i + "|" + countN);
            if (treeSet.size() > k) {
                treeSet.remove(treeSet.last());
            }
        }
        int counter = 0;
        for (String res : treeSet) {
            result[counter] = Integer.parseInt(res.split("\\|")[0]);
            counter++;
        }
        return result;
    }
}

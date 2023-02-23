package leetcode.java;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll384 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0]) {
                        return 1;
                    } else if (o1[0] < o2[0]) {
                        return -1;
                    } else {
                        return o2[1] - o1[1];
                    }
                }
            });
            int[] dp = new int[envelopes.length];
            dp[0] = 1;
            for (int i = 1; i < envelopes.length; i++) {
                if (envelopes[i][0] > envelopes[i - 1][0]
                        && envelopes[i][1] > envelopes[i - 1][1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            int max = 1;
            for (int i : dp) {
                max = Math.max(max, i);
            }
            return max;
        }
    }
}
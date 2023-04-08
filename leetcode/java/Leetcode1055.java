package leetcode.java;

public class Leetcode1055 {
    class Solution {
        public int shortestWay(String source, String target) {
            // go through target, for each time, check the length of source
            // check if inside this length, target has a sub array of source
            // if so, we move the length of sub array and check next range
            // let's begin
            int count = 0;
            int len = source.length();
            int s = 0;
            int t = 0;
            while (t < target.length()) {
                int before = t;
                for (s = 0; s < len; s++) {
                    if (t >= target.length()) {
                        // means all passed
                        break;
                    }
                    if (source.charAt(s) == target.charAt(t)) {
                        // if match, move t to next
                        t++;
                    }
                }
                // failure situation
                // if t do not move, means current letter in target not in source
                if (t == before) {
                    return -1;
                }
                // we successfull checked one part in target that is sub array of source
                count++;
            }
            return count;
        }
    }
}

package leetcode.java;

/**
 * https://leetcode.com/problems/shortest-way-to-form-string/
 * 
 * Related: leetcode 392
 */
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

    class Solution2 {
        public int shortestWay(String source, String target) {
            // we want to start search from 0, but char at 0 is hard to judge, so we just
            // right move for one step
            source = "#" + source;
            int count = 1;
            int[][] arr = buildArr(source);

            int pointer = 0;
            for (int i = 0; i < target.length();) {
                int next = arr[pointer][target.charAt(i) - 'a'];
                if (next != -1) {
                    // find the letter we want in the right
                    pointer = next;
                    // we plus i only when we find
                    // because when reset, we have to search for the same one again
                    i++;
                } else {
                    if (pointer == 0) {
                        // current letter is not in source
                        return -1;
                    }
                    // current letter may be in source, reset
                    pointer = 0;
                    count++;
                }
            }
            return count;
        }

        private int[][] buildArr(String source) {
            int[][] arr = new int[source.length()][26];
            // right most
            for (int i = 0; i < 26; i++) {
                // for the right most, there's no letter on its right
                arr[source.length() - 1][i] = -1;
            }
            for (int i = source.length() - 2; i >= 0; i--) {
                // for others, we consider import from its right and include itself
                for (int j = 0; j < 26; j++) {
                    // copy from right
                    arr[i][j] = arr[i + 1][j];
                }
                // then the right one itself
                arr[i][source.charAt(i + 1) - 'a'] = i + 1;
            }
            return arr;
        }
    }

    // for (int[] one : buildArr(source)) {
    // for (int two : one) {
    // System.out.print(two + " ");
    // }
    // System.out.println();
    // }
}

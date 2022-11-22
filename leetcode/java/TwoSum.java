package leetcode.java;

import java.util.HashMap;

public class TwoSum {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int position = 0;
        for (int n : nums) {
            int minus = target - n;
            if (map.containsKey(minus)) {
                result[0] = position;
                result[1] = map.get(minus);
                return result;
            } else {
                map.put(n, position);
            }
            position++;
        }
        return result;
    }
}
package leetcode.java;

import java.util.Arrays;

public class ThreeSumClosetest16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int min = 13001; // maximum value we can get for the sub between sum and target
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                // moving two pointers to find the closest
                // and to avoid looping 3 times
                while (left < right) {
                    int sum = curr + nums[left] + nums[right];
                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                    int offset = Math.abs(target - sum);
                    if (offset < min) {
                        min = offset;
                        res = sum;
                    }
                }
            }
            return res;
        }
    }
}

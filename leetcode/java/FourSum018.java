package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum018 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                int curri = nums[i];
                if (curri > target / 4) {
                    // no need to go further
                    break;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int currj = nums[j];
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        if (curri + currj + nums[left] + nums[right] == target) {
                            res.add(Arrays.asList(new Integer[] { curri, currj, nums[left], nums[right] }));
                            right--;
                            left++;
                            while (left < right && nums[left] == nums[left - 1]) {
                                // jump duplicate
                                left++;
                            }
                            while (left < right && nums[right] == nums[right + 1]) {
                                // jump duplicate
                                right--;
                            }
                        } else if (curri + currj + nums[left] + nums[right] > target) {
                            right--;
                        } else {
                            left++;
                        }
                        while (j < nums.length - 3 && nums[j] == nums[j + 1]) {
                            // jump duplicate
                            j++;
                        }
                    }
                    while (i < nums.length - 4 && nums[i] == nums[i + 1]) {
                        // jump duplicate
                        i++;
                    }
                }
            }
            return res;
        }
    }
}

package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // -1,0,1,2,-1,-4
            Arrays.sort(nums);
            // -4,-1,-1, 0, 1, 2
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int first = nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (first + nums[left] + nums[right] == 0) {
                        result.add(Arrays.asList(new Integer[] { first, nums[left], nums[right] }));
                        // change to another pair
                        left++;
                        right--;
                        // skip same value, because first not change ,if same value, will result in
                        // duplicate
                        // for example: [-2,0,0,2,2] => [[-2,0,2],[-2,0,2]]
                        while (left < right && nums[left] == nums[left - 1]) {
                            // here for multiple duplicate, we cannot use if
                            // we use while
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (first + nums[left] + nums[right] > 0) {
                        right--; // reduce a little bit
                    } else {
                        left++; // add a little bit
                    }
                }
            }
            return result;
        }
    }

    // Solution By AI
    class Solution2 {
        public static List<List<Integer>> threeSum(int[] nums) {
            // Sort the array
            Arrays.sort(nums);
            // Initialize a list to store the triplets
            List<List<Integer>> triplets = new ArrayList<>();
            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Check if the current element is the same as the previous element
                // We do this to avoid adding duplicate triplets to the list
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // Initialize two pointers, left and right, to search for the other two elements
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // If the sum of the three elements is zero, add the triplet to the list
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // Move the left and right pointers inward to continue searching for other
                        // triplets
                        left += 1;
                        right -= 1;
                        // Skip any duplicate elements
                        while (left < right && nums[left] == nums[left - 1]) {
                            left += 1;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right -= 1;
                        }
                    }
                    // If the sum is greater than zero, move the right pointer inward to decrease
                    // the sum
                    else if (nums[i] + nums[left] + nums[right] > 0) {
                        right -= 1;
                    }
                    // If the sum is less than zero, move the left pointer inward to increase the
                    // sum
                    else {
                        left += 1;
                    }
                }
            }
            // Return the list of triplets
            return triplets;
        }

    }
}

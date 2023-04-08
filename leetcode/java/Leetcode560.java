package leetcode.java;

import java.util.HashMap;
import java.util.Map;

public class Leetcode560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] += sum[i - 1] + nums[i];
            }
            for (int i = 0; i < sum.length; i++) {
                // firstly sum itself can be the result
                if (sum[i] == k)
                    count++;
                for (int j = i + 1; j < sum.length; j++) {
                    // then every subtraction can be a sub array between
                    if (sum[j] - sum[i] == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] += sum[i - 1] + nums[i];
            }
            map.put(0, 1);
            for (int i = 0; i < sum.length; i++) {
                //
                if (map.containsKey(sum[i] - k)) {
                    // means there should be at least one j that satisfies sum[i] - sum[j] == k
                    int curr = map.get(sum[i] - k);
                    count += curr;
                }
                map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
            }
            return count;
        }
    }

    class BruteForce {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    // we do not start from i + 1
                    // because we have to consider num[i] itself as the sub array
                    sum += nums[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}

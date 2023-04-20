package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1557 {
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            // find nodes that no other nodes point to them
            int[] dependencies = new int[n];
            // assume that all nodes are used in any kinds of ways
            for (List<Integer> edge : edges) {
                dependencies[edge.get(1)] ++;
            }
            List<Integer> res = new ArrayList<>();
            // find all nodes which has no other nodes points to them
            for (int i = 0; i < n; i++) {
                if (dependencies[i] == 0) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}

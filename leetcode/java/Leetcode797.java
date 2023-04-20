package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class Leetcode797 {
    class Solution {

        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            LinkedList<Integer> path = new LinkedList<>();
            dfs(graph, 0, path);
            return res;
        }

        private void dfs(int[][] graph, int cur, List<Integer> path) {
            // if (graph[cur].length == 0) {
            if (cur == graph.length - 1) {
                // we reach the end
                path.add(cur);
                res.add(deepCopy(path));
                path.remove(path.size() - 1);
                return;
            }
            path.add(cur);
            // add current to path
            for (int adj : graph[cur]) {
                // go to next
                dfs(graph, adj, path);
            }
            path.remove(path.size() - 1);
        }

        private List<Integer> deepCopy(List<Integer> path) {
            List<Integer> copy = new LinkedList<>();
            for (int p : path) {
                copy.add(p);
            }
            return copy;
        }
    }
}

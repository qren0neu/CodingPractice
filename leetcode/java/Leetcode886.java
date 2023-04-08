package leetcode.java;

import java.util.*;

/**
 * https://leetcode.com/problems/possible-bipartition/description/
 */
public class Leetcode886 {
    class Solution {

        private List<Integer>[] graph; // the adj list
        private int[] group; // which group the node in, 1 group 1, -1 group 2, 0 not visited

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // init everything
            graph = new LinkedList[n + 1];
            group = new int[n + 1];
            // put empty lists in to the graph
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<Integer>();
            }
            // construct the graph
            for (int[] dislike : dislikes) {
                // undirected
                graph[dislike[0]].add(dislike[1]);
                graph[dislike[1]].add(dislike[0]);
            }
            // traverse the graph
            // may be unconnected components
            for (int i = 1; i <= n; i++) {
                // if not visited, begin
                if (group[i] == 0 && !dfs(i, 1)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 1. current node
         * 2. groupAssign, which group the node is expected to be in
         */
        private boolean dfs(int current, int groupAssign) {
            // check if visited
            if (group[current] == 0) {
                // not visited
                group[current] = groupAssign;
                // go to other nodes
                for (int adj : graph[current]) {
                    if (!dfs(adj, -group[current])) {
                        return false;
                    }
                }
                return true;
            } else {
                // visited
                return group[current] == groupAssign;
            }
        }
    }
}

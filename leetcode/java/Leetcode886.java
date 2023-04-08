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

    class Solution2 {
        private List<Integer>[] graph;
        private int[] group;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // init the graph
            graph = new LinkedList[n + 1];
            group = new int[n + 1];
            // UnionFind uf = new UnionFind(n);
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] dislike : dislikes) {
                graph[dislike[0]].add(dislike[1]);
                graph[dislike[1]].add(dislike[0]);
            }
            for (int i = 1; i <= n; i++) {
                if (group[i] == 0 && !dfs(i, 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int current, int groupAssign) {
            // check visited
            if (group[current] == 0) {
                // assign value and go to next
                group[current] = groupAssign;
                for (int adj : graph[current]) {
                    if (!dfs(adj, -groupAssign)) {
                        return false;
                    }
                }
                return true;
            } else {
                // return
                return group[current] == groupAssign;
            }
        }
    }

    class Solution3 {
        private List<Integer>[] graph;
        private int[] visited;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // init the graph
            graph = new LinkedList[n + 1];
            visited = new int[n + 1];
            // UnionFind uf = new UnionFind(n);
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] dislike : dislikes) {
                graph[dislike[0]].add(dislike[1]);
                graph[dislike[1]].add(dislike[0]);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (visited[i] != 0)
                    continue;
                q.offer(i);
                visited[i] = 1; // assign a group
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int adj : graph[curr]) {
                        if (visited[adj] == 0) {
                            // not visited
                            visited[adj] = -visited[curr];
                            q.offer(adj);
                        } else {
                            if (visited[adj] != -visited[curr]) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

    }

    class Solution4 {
        private List<Integer>[] graph;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            graph = new LinkedList[n + 1];
            UnionFind uf = new UnionFind(n);
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] dislike : dislikes) {
                graph[dislike[0]].add(dislike[1]);
                graph[dislike[1]].add(dislike[0]);
            }
            for (int i = 1; i <= n; i++) {
                if (graph[i].size() == 0)
                    continue;
                int root = graph[i].get(0);
                for (int adj : graph[i]) {
                    if (uf.isConnected(adj, i))
                        return false;
                    uf.union(root, adj);
                }
            }
            return true;
        }

        static class UnionFind {
            private int[] parent;
            private int[] rank;

            UnionFind(int n) {
                parent = new int[n + 1];
                rank = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int p, int q) {
                int proot = find(p);
                int qroot = find(q);
                if (proot == qroot)
                    return;
                if (rank[p] > rank[q]) {
                    parent[qroot] = proot;
                    rank[p]++;
                } else {
                    parent[proot] = qroot;
                    rank[q]++;
                }
            }

            public int find(int p) {
                while (parent[p] != p) {
                    p = parent[p];
                }
                return p;
            }

            public boolean isConnected(int p, int q) {
                return find(p) == find(q);
            }
        }
    }
}

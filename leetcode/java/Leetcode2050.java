package leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode2050 {
    class Solution {
        public int minimumTime(int n, int[][] relations, int[] time) {
            // distTo and time are both 0 ~ n - 1, which position is 1 less than index
            int month = 0;
            int[] distTo = new int[n];
            int[] preCount = new int[n];
            LinkedList<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[n];
            for (int i = 0; i < n; i++) {
                // initialize
                distTo[i] = Integer.MIN_VALUE;
                preCount[i] = 0;
                graph[i] = new LinkedList<Integer>();
            }
            // init the graph
            for (int[] relation : relations) {
                int course = relation[1] - 1;
                int pre = relation[0] - 1;
                // implement adj list
                graph[pre].add(course);
                preCount[course]++;
            }
            Queue<Integer> pq = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                if (preCount[i] == 0) {
                    // add course
                    pq.offer(i);
                    distTo[i] = time[i];
                }
            }
            while (!pq.isEmpty()) {
                int s = pq.size();
                for (int i = 0; i < s; i++) {
                    // here course is course - 1
                    int course = pq.poll();
                    LinkedList<Integer> adj = graph[course];
                    for (int next : adj) {
                        distTo[next] = Math.max(distTo[next], distTo[course] + time[next]);
                        preCount[next]--;
                        if (preCount[next] == 0) {
                            pq.offer(next);
                        }
                    }
                }
            }
            for (int val : distTo) {
                month = Math.max(val, month);
            }
            return month;
        }
    }
}

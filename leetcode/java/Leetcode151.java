package leetcode.java;

import java.util.Stack;

public class Leetcode151 {
    static class Solution {
        public String reverseWords(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (s.charAt(left) == ' ') {
                left++;
            }
            while (s.charAt(right) == ' ') {
                right--;
            }
            s = s.substring(left, right + 1); // remove all white spaces at side
            int quick = 0;
            int slow = 0;
            Stack<String> stack = new Stack<>();
            while (quick < s.length()) {
                if (s.charAt(quick) != ' ') {
                    quick++;
                } else {
                    // if meet white space
                    stack.push(s.substring(slow, quick));
                    while (s.charAt(quick) == ' ') {
                        quick++;
                    }
                    slow = quick;
                }
            }
            if (quick > slow) {
                stack.push(s.substring(slow, quick));
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
                sb.append(" ");
            }
            // sb.substring(0, sb.length() - 1);
            return sb.substring(0, sb.length() - 1).toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
    }
}

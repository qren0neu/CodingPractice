package datastructure.lecture1;

import java.util.Stack;

public class CalculatorZY {
    public static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().solution("1+1"));
        }

        public int solution(String s) {
            Stack<Integer> s1 = new Stack<>(); // number
            // qr: recommend to name it as "numberStack"
            Stack<Character> s2 = new Stack<>(); // sign of operation
            // qr: recommend to name it as "operatorStack"
            StringBuffer sbuf = new StringBuffer();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    sbuf.append(c);
                } else if (c == '+' || c == '-' || c == ')') {
                    s1.push(Integer.parseInt(sbuf.toString()));
                    sbuf.setLength(0);
                    if (c == '+' || c == '-') {
                        s2.push(c);
                    }
                    if (c == ')') {
                        int c1 = s1.pop();
                        int c2 = s1.pop();
                        char symbol = s2.pop();
                        if (symbol == '+') {
                            int oc = (c1 + c2);
                            s1.push(oc);
                        } else {
                            int oc = c2 - c1;
                            s1.push(oc);
                        }
                    }
                }
            }
            while (!s2.isEmpty()) {
                int c1 = s1.pop();
                int c2 = s1.pop();
                char symbol = s2.pop();
                if (symbol == '+') {
                    int oc = (c1 + c2);
                    s1.push(oc);
                } else {
                    int oc = c2 - c1;
                    s1.push(oc);
                }
            }
            return s1.peek();
        }
    }
}

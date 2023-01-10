package leetcode.java;

import java.util.Stack;

public class BasicCalculatorII227 {
    static class Solution {

        private Stack<Character> operatorStack = new Stack<>();
        private Stack<Integer> numberStack = new Stack<>();

        public int calculate(String s) {
            int total = 0;
            int minusFlag = 1;
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (Character.isDigit(curr)) {
                    total = total * 10 + (curr - '0');
                } else {
                    switch (curr) {
                        case '-':
                            minusFlag = -1;
                        case '+':
                            // we always use '+'
                            operatorStack.push('+');
                            break;
                        case '*':
                            // popAndCalculate
                        case '/':

                    }
                    numberStack.push(total * minusFlag);
                    minusFlag = 1;
                    total = 0;
                }
            }
            if (total != 0) {
                numberStack.push(total * minusFlag);
            }
            return 0;
        }
    }
}

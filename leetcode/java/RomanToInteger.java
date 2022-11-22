package leetcode.java;

import java.util.Stack;

public class RomanToInteger {
    private Stack<Character> stack = new Stack<>();

    public int romanToInt(String s) {
        int result = 0;
        char[] symbols = s.toCharArray();
        for (int i = symbols.length - 1; i >= 0; i--) {
            char c = symbols[i];
            if (stack.empty() || compareWithTop(c)) {
                stack.push(c);
            } else {
                stack.push(c);
                result = popAll(result);
            }
        }
        if (!stack.empty()) {
            result = popAll(result);
        }
        return result;
    }

    private boolean compareWithTop(char c) {
        char peek = stack.peek();
        return getVal(c) >= getVal(peek);
    }

    private int popAll(int num) {
        if (stack.size() == 1) {
            return num + getVal(stack.pop());
        }
        int first = getVal(stack.pop());
        int last = first;
        int curr = 0;
        while (!stack.empty()) {
            curr = getVal(stack.pop());
            if (curr <= last) {
                num += first;
                num += curr;
            } else {
                num += curr - last;
            }
            last = curr;
            first = 0;
        }
        return num;
    }

    private int getVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}

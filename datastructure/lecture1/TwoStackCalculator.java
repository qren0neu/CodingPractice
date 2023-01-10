package datastructure.lecture1;

import java.util.Stack;

public class TwoStackCalculator {
    private Stack<Float> valueStack = new Stack<>();
    private Stack<Character> operatorStack = new Stack<>();

    public float calculate(String formula) {
        formula = formula.replaceAll(" ", "");
        for (int i = 0; i < formula.length(); i++) {
            char curr = formula.charAt(i);
            int num = curr - '0';
            if (0 <= num && num < 10) {
                // is number
                valueStack.push(num * 1.0f);
            } else {
                switch (curr) {
                    case '(':
                        continue;
                    case ')':
                        popAndCalculate();
                        break;
                    default:
                        operatorStack.push(curr);
                        break;
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            popAndCalculate();
        }
        return valueStack.isEmpty() ? 0f : valueStack.pop();
    }

    private void popAndCalculate() {
        if (valueStack.isEmpty() || operatorStack.isEmpty()) {
            valueStack.push(0f);
            return;
        }
        float val = 0;
        float valRight = valueStack.pop();
        float valLeft = valueStack.pop();
        char operator = operatorStack.pop();
        switch (operator) {
            case '-':
                val = valLeft - valRight;
                break;
            case '+':
                val = valLeft + valRight;
                break;
            case '*':
                val = valLeft * valRight;
                break;
            case '/':
                val = valLeft / valRight;
                break;
        }
        valueStack.push(val);
    }

    public static void main(String[] args) {
        float res = new TwoStackCalculator().calculate("((1 + 2) / 3) + 4 + (5 * 6) / ((2 * 5) + 5)");
        // cannot solve (1 + 2) / 3 + 4 + (5 * 6) / ((2 * 5) + 5)
        // 3 / 3 + 4 + 2
        System.out.println(res);
    }
}

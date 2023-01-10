package datastructure.lecture1;

import java.util.Stack;

public class TwoStackCalculator2 {
    private Stack<Float> valueStack = new Stack<>();
    private Stack<Character> operatorStack = new Stack<>();

    public float calculate(String formula) {
        boolean popFlag = false;
        formula = formula.replaceAll(" ", "");
        for (int i = 0; i < formula.length(); i++) {
            char curr = formula.charAt(i);
            int num = curr - '0';
            if (0 <= num && num < 10) {
                // is number
                valueStack.push(num * 1.0f);
            } else {
                switch (curr) {
                    // case '(':
                    // continue;
                    case ')':
                        popAndCalculate();
                        popFlag = false;
                        break;
                    case '*':
                    case '/':
                        popFlag = true;
                        operatorStack.push(curr);
                        break;
                    case '-':
                        if (popFlag) {
                            popAndCalculate();
                            popFlag = false;
                        }
                        popFlag = true;
                        operatorStack.push(curr);
                        break;
                    case '+':
                        if (popFlag) {
                            popAndCalculate();
                            popFlag = false;
                        }
                        operatorStack.push(curr);
                        break;
                    default:
                        operatorStack.push(curr);
                        break;
                }
            }
        }
        popAndCalculate();
        return valueStack.isEmpty() ? 0f : valueStack.pop();
    }

    private void popAndCalculate() {
        while (!operatorStack.isEmpty()) {
            float val = 0;
            char operator = operatorStack.pop();
            if (operator == '(') {
                break;
            }
            float valRight = valueStack.pop();
            float valLeft = valueStack.pop();
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
    }

    public static void main(String[] args) {
        float res = new TwoStackCalculator2()
                .calculate(
                        "((1 - 1 + 1 / 1) + (1 + 2 / (2 + 2 - 2) - 2)) + ((1 + 2) / 3) + (4 + 5 - 5 + 6 + 6 / 3 - 2) + (5 * 6) / ((2 * 5) + 5)");
        // still having issues
        System.out.println(res);
    }
}

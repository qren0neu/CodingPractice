package leetcode.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateParentheses022 {
    @Deprecated // This cannot cover some situation like "(())(())"
    class Solution {
        public List<String> generateParenthesis(int n) {
            // list start from 0, so finally we need n - 1
            List<Set<String>> dp = new ArrayList<>();
            Set<String> dp0 = new HashSet<>();
            dp0.add("()");
            Set<String> dp1 = new HashSet<>();
            dp1.add("(())");
            dp1.add("()()");
            dp.add(dp0);
            dp.add(dp1);
            n--;
            for (int i = 2; i <= n; i++) {
                Set<String> dpn = new HashSet<>();
                Set<String> prev = dp.get(i - 1);
                for (String s : prev) {
                    dpn.add("(" + s + ")");
                    dpn.add("()" + s);
                    dpn.add(s + "()");
                }
                dp.add(dpn);
            }
            List<String> res = new ArrayList<>();
            res.addAll(dp.get(n));
            return res;
        }
    }

    class Solution2 { // And this cannot handle: "(()())(()())"
        public List<String> generateParenthesis(int n) {
            // list start from 0, so finally we need n - 1
            Map<String, Object> dupCheck = new HashMap<>();
            List<List<String[]>> dp = new ArrayList<>();
            List<String[]> dp0 = new ArrayList<>();
            dp0.add(new String[] { "()" });
            List<String[]> dp1 = new ArrayList<>();
            dp1.add(new String[] { "(())" });
            dp1.add(new String[] { "()", "()" });
            dp.add(dp0);
            dp.add(dp1);
            n--;
            for (int i = 2; i <= n; i++) {
                List<String[]> dpn = new ArrayList<>();
                List<String[]> prev = dp.get(i - 1);
                for (String[] ss : prev) {
                    // 1: add () at first
                    String[] addHead = new String[ss.length + 1];
                    addHead[0] = "()";
                    System.arraycopy(ss, 0, addHead, 1, ss.length);
                    StringBuilder sb1 = new StringBuilder();
                    for (String s : addHead) {
                        sb1.append(s);
                    }
                    String str1 = sb1.toString();
                    if (!dupCheck.containsKey(str1)) {
                        dupCheck.put(str1, null);
                        dpn.add(addHead);
                    }
                    // 2: add() at last
                    String[] addLast = new String[ss.length + 1];
                    addLast[ss.length] = "()";
                    System.arraycopy(ss, 0, addLast, 0, ss.length);
                    StringBuilder sb2 = new StringBuilder();
                    for (String s : addLast) {
                        sb2.append(s);
                    }
                    String str2 = sb2.toString();
                    if (!dupCheck.containsKey(str2)) {
                        dupCheck.put(str2, null);
                        dpn.add(addLast);
                    }
                    // 3: add () to each
                    int cursor = 0;
                    while (cursor < ss.length) {
                        String[] ssn = new String[ss.length];
                        for (int j = 0; j < ss.length; j++) {
                            String current = ss[j];
                            if (j == cursor) {
                                current = "(" + current + ")";
                            }
                            ssn[j] = current;
                        }
                        cursor++;
                        StringBuilder sb3 = new StringBuilder();
                        for (String s : ssn) {
                            sb3.append(s);
                        }
                        String str3 = sb3.toString();
                        if (!dupCheck.containsKey(str3)) {
                            dupCheck.put(str3, null);
                            dpn.add(ssn);
                        }
                    }
                    // 4: add() to all
                    StringBuilder sb4 = new StringBuilder("(");
                    for (String s : ss) {
                        sb4.append(s);
                    }
                    sb4.append(")");
                    String str4 = sb4.toString();
                    if (!dupCheck.containsKey(str4)) {
                        dupCheck.put(str4, null);
                        dpn.add(new String[] { str4 });
                    }
                }
                dp.add(dpn);
            }
            List<String> res = new ArrayList<>();
            for (String[] ss : dp.get(n)) {
                StringBuilder sb = new StringBuilder();
                for (String s : ss) {
                    sb.append(s);
                }
                res.add(sb.toString());
            }
            return res;
        }
    }

    class Solution3 {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            generateParenthesisImpl(n, n, "", res);
            return res;
        }

        public void generateParenthesisImpl(int open, int close, String str, List<String> res) {
            if (open == 0 && close == 0) {
                // open parenthesis matches close parenthesis
                // after return, go to last open (because close is returned or finished)
                // for example, when (((()))) is finished
                // go to ((( -> ((() -> ((()()))
                res.add(str);
                return;
            }

            if (open > 0) {
                // we cannot use "(" + str here
                // or we may only get "(((())))", because it is adding "(" at front
                generateParenthesisImpl(open - 1, close, str + "(", res);
            }
            if (close > open) {
                // close always after open
                generateParenthesisImpl(open, close - 1, str + ")", res);
            }
        }
    }

    class Solution4 {
        public List<String> generateParenthesis(int n) {
            List<List<String>> dp = new ArrayList<>();
            // we are starting from 1, 0 is used to store ""
            // we do not need to use if to check 0, so we start from 1
            dp.add(Collections.singletonList("")); // first to know this
            for (int i = 1; i <= n; i++) {
                // from 0 to i, and keep each dp we get need to equals n - 1
                // because we have to add a new "()"" each time
                List<String> sum = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    for (String target : dp.get(j)) {
                        for (String ori : dp.get(i - j - 1)) {
                            sum.add("(" + target + ")" + ori);
                        }
                    }
                }
                dp.add(sum);
            }
            return dp.get(n);
        }
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParentheses022().new Solution4().generateParenthesis(3);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}

package leetcode.practice;

public class ExchangeCharInString {
    public String change(String s) {
        char[] arr = s.toCharArray();
        char[] narr = new char[arr.length];
        for (int i = 0, k = 0, j = narr.length - 1;; i++, j--, k += 2) {
            if (i > j) {
                break;
            }
            if (i == j) {
                narr[k] = arr[i];
                break;
            }
            narr[k] = arr[i];
            narr[k + 1] = arr[j];
        }
        return new String(narr);
    }

    public static void main(String[] args) {
        ExchangeCharInString obj = new ExchangeCharInString();
        System.out.println(obj.change("abcdef"));
        System.out.println(obj.change("abcde"));
    }
}

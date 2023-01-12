package leetcode.practice;

public class LoopTest {

    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                }
            }
        }
    }

}

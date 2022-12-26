package leetcode.practice;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new QuickSort().sort(new int[] { 24, 18, 38, 43, 14, 40, 1, 54 });
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        if (right - left <= 1) {
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            return;
        }
        int start = left;
        int end = right;
        int pivot = right;
        int pv = arr[right];
        right--;
        while (left < right) {
            while (arr[left] < pv) {
                left++;
            }
            while (right > left && arr[right] > pv) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        swap(arr, left, pivot);
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

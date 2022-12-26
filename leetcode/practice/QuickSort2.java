package leetcode.practice;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = { 95, 13, 47, 52, 41, 68, 42 };
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
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
        int pivot = findMedian(arr, left, right);
        int pv = arr[pivot];
        swap(arr, pivot, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            while (arr[i] < pv) {
                i++;
            }
            while (arr[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, i, right);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public int findMedian(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int a = arr[left];
        int b = arr[mid];
        int c = arr[right];
        if (a < b) {
            if (b < c) {
                return mid;
            } else if (a < c) {
                return right;
            } else {
                return left;
            }
        } else {
            if (a < c) {
                return left;
            } else if (b < c) {
                return right;
            } else {
                return mid;
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

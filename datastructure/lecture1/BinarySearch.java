package datastructure.lecture1;

public class BinarySearch {
    public int findPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            int val = arr[mid];
            if (val > target) {
                right = mid;
            } else if (val < target) {
                left = mid;
            } else {
                return mid;
            }
        }
        if (arr[left] == target) {
            return left;
        }
        if (arr[right] == target) {
            return right;
        }
        return -1;
    }

    public int findPosition2(int[] arr, int target) {
        // code optimization
        int left = 0;
        int right = arr.length - 1;
        // we include left == right here so that we use one more judge
        // to determine whether left or right in the special case
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid interger overflow
            int val = arr[mid];
            if (val > target) {
                right = mid - 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 5, 6 };
        int pos = new BinarySearch().findPosition(arr, 2);
        System.out.println(pos);
    }
}

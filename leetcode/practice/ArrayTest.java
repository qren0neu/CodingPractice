package leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayTest<T> {
    public static void main(String[] args) {
        Comparable[] comArr = new Comparable[4];
        Object[] objArr = new Object[4];
        Object[] objArr2 = new Integer[4];
        Object[] objArr3 = new ArrayTest[4];
        Object o = new Comparable() {
            public int compareTo(Object o) {
                return 0;
            };
        };
        Arrays.sort(objArr3);
        Arrays.binarySearch(objArr3, o);

        Integer[] arr = new Integer[5];
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return 0;
            }
        });
        int[] arr2 = new int[5];
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return 0;
            }
        });

    }

    public void testMethod() {
        T a = null;
        // T a = new T();
    }
}

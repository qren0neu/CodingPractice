package leetcode.practice;

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
    }

    public void testMethod() {
        T a = null;
        // T a = new T();
    }
}

package leetcode.java;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] fullnum = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        while (p1 < l1 || p2 < l2) {
            int n1 = Integer.MAX_VALUE;
            int n2 = Integer.MAX_VALUE;
            if (p1 < l1) {
                n1 = nums1[p1];
            }
            if (p2 < l2) {
                n2 = nums2[p2];
            }
            if (n1 < n2) {
                fullnum[p1 + p2] = n1;
                p1++;
            } else {
                fullnum[p1 + p2] = n2;
                p2++;
            }
        }
        if ((l1 + l2) % 2 == 0) {
            int pos = (l1 + l2) / 2 - 1;
            return (fullnum[pos] + fullnum[pos + 1]) / 2.0;
        } else {
            return fullnum[(l1 + l2 + 1) / 2 - 1];
        }
    }
}

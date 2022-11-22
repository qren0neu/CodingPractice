package leetcode.java;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int sumWealth = 0;
            for (int wealth : account) {
                sumWealth += wealth;
            }
            maxWealth = Math.max(sumWealth, maxWealth);
        }
        return maxWealth;
    }
}

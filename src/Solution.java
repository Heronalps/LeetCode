
import java.math.BigInteger;
import java.util.*;
import java.sql.Timestamp;


class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) return max(prices); // Pruning成不限交易次数

        int rows = Math.min(2 * k, prices.length);
        int[][] dp = new int[rows + 1][2];
        dp[0][0] = dp[0][1] = 0; // 设为0，为了让第一天必须买，0 - prices[0]
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = Math.min(rows, i + 1); j >= 1; j--) {
                if (i + 1 <= rows && j == Math.min(rows, i + 1)) { // 第二个条件很重要，j只有在最下一行，才能赋MIN_VALUE
                    dp[j][0] = dp[j][1] = Integer.MIN_VALUE;
                }
                if (j % 2 == 1) { // 奇数operation，Hold
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                }
                else { // 偶数operation，Sold
                    dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] + prices[i]);
                    max = Math.max(max, dp[j][1]);
                }
            }
        }
        return max;
    }
    private int max(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(2, new int[] {1,2,3,4,5,20,0,30}));
    }
}


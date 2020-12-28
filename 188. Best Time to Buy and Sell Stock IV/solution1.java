/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (27.83%)
 * Likes:    1438
 * Dislikes: 91
 * Total Accepted:    127.6K
 * Total Submissions: 458.2K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * Say you have an array for which the i-th element is the price of a given
 * stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 *
 * Example 1:
 *
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 =
 * 3.
 *
 *
 */

// @lc code=start
class Solution {
  public int maxProfit(int k, int[] prices) {
    var n = prices.length;
    if (n == 0) {
      return 0;
    }

    if (k > n / 2) {
      return maxProfit(prices);
    }

    var dp = new int[n + 1][k + 1][2];
    for (var i = 0; i <= n; ++i) {
      dp[i][0][1] = Integer.MIN_VALUE;
    }
    for (var i = 0; i <= k; ++i) {
      dp[0][i][1] = Integer.MIN_VALUE;
    }

    for (var i = 1; i <= n; ++i) {
      for (var j = k; j >= 1; --j) {
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
      }
    }

    return dp[n][k][0];
  }

  public int maxProfit(int[] prices) {
    var n = prices.length;

    var dp = new int[n + 1][2];
    dp[0][1] = Integer.MIN_VALUE;

    for (var i = 1; i <= n; ++i) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
    }

    return dp[n][0];
  }
}
// @lc code=end

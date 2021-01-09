/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (39.61%)
 * Likes:    3081
 * Dislikes: 82
 * Total Accepted:    268.4K
 * Total Submissions: 677.4K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e.,
 * you must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 *
 * Example 2:
 *
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 *
 *
 * Example 3:
 *
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * Example 4:
 *
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 *
 *
 */

// @lc code=start
class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    var n = prices.length;
    var k = 2;
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
}
// @lc code=end

/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (41.96%)
 * Likes:    894
 * Dislikes: 129
 * Total Accepted:    93.7K
 * Total Submissions: 223.1K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output
 * the maximum average value.
 *
 * Example 1:
 *
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 *
 *
 *
 *
 */

// @lc code=start
class Solution {
  public double findMaxAverage(int[] nums, int k) {
    var left = 0;
    var right = left + k;
    var sum = 0;
    for (var i = left; i < right; ++i) {
      sum += nums[i];
    }
    var maxSum = sum;

    while (right < nums.length) {
      sum += nums[right] - nums[left];
      ++left;
      ++right;
      maxSum = Math.max(maxSum, sum);
    }

    return (double) maxSum / k;
  }
}
// @lc code=end

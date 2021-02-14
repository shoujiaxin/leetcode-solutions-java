/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (53.16%)
 * Likes:    1079
 * Dislikes: 380
 * Total Accepted:    350.8K
 * Total Submissions: 661.8K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 *
 * Example 1:
 *
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 *
 *
 *
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 *
 */

// @lc code=start
class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    var len = 0;
    var res = 0;

    for (var n : nums) {
      if (n == 1) {
        ++len;
        res = Math.max(res, len);
      } else {
        len = 0;
      }
    }

    return res;
  }
}
// @lc code=end

/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (56.11%)
 * Likes:    3843
 * Dislikes: 281
 * Total Accepted:    341.2K
 * Total Submissions: 608.1K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 *
 */

// @lc code=start
class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (var n : nums) {
      var index = Math.abs(n) - 1;
      if (nums[index] > 0) {
        nums[index] *= -1;
      }
    }

    var res = new ArrayList<Integer>();
    for (var i = 0; i < nums.length; ++i) {
      if (nums[i] > 0) {
        res.add(i + 1);
      }
    }
    return res;
  }
}
// @lc code=end

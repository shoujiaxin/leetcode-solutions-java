/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (55.82%)
 * Likes:    1263
 * Dislikes: 799
 * Total Accepted:    685.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 *
 * Input: [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 *
 * Input: [1,2,3,4]
 * Output: false
 *
 * Example 3:
 *
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 */

// @lc code=start
class Solution {
  public boolean containsDuplicate(int[] nums) {
    var set = new HashSet<Integer>();
    for (var num : nums) {
      if (set.contains(num)) {
        return true;
      }

      set.add(num);
    }

    return false;
  }
}
// @lc code=end

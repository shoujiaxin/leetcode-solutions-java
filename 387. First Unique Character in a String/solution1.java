/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (53.65%)
 * Likes:    2456
 * Dislikes: 129
 * Total Accepted:    644.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '"leetcode"'
 *
 * Given a string, find the first non-repeating character in it and return its
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 *
 */

// @lc code=start
class Solution {
  public int firstUniqChar(String s) {
    var charCnt = new int[26];
    for (var ch : s.toCharArray()) {
      ++charCnt[ch - 'a'];
    }

    for (var i = 0; i < s.length(); ++i) {
      if (charCnt[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }

    return -1;
  }
}
// @lc code=end

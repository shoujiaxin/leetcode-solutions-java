/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (40.21%)
 * Likes:    1735
 * Dislikes: 429
 * Total Accepted:    331.2K
 * Total Submissions: 822.6K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 *
 * Example 1:
 *
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 *
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 *
 */

// @lc code=start
class Solution {
  public boolean isIsomorphic(String s, String t) {
    var s2t = new HashMap<Character, Character>();
    var t2s = new HashMap<Character, Character>();

    for (var i = 0; i < s.length(); ++i) {
      var ch1 = s.charAt(i);
      var ch2 = t.charAt(i);

      if ((s2t.containsKey(ch1) && s2t.get(ch1) != ch2)
          || (t2s.containsKey(ch2) && t2s.get(ch2) != ch1)) {
        return false;
      }

      s2t.put(ch1, ch2);
      t2s.put(ch2, ch1);
    }

    return true;
  }
}
// @lc code=end

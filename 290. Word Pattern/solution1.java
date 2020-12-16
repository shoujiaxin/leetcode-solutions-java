/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (38.16%)
 * Likes:    1602
 * Dislikes: 199
 * Total Accepted:    236.8K
 * Total Submissions: 620.4K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s.
 *
 *
 * Example 1:
 *
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 *
 * Example 3:
 *
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 * Example 4:
 *
 *
 * Input: pattern = "abba", s = "dog dog dog dog"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lower-case English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 *
 *
 */

// @lc code=start
class Solution {
  public boolean wordPattern(String pattern, String s) {
    var scanner = new Scanner(s);
    var p2s = new HashMap<Character, String>();
    var s2p = new HashMap<String, Character>();

    for (var ch : pattern.toCharArray()) {
      if (!scanner.hasNext()) {
        return false;
      }
      var word = scanner.next();

      if (!p2s.containsKey(ch) && !s2p.containsKey(word)) {
        p2s.put(ch, word);
        s2p.put(word, ch);
      } else if (!word.equals(p2s.get(ch)) || !Character.valueOf(ch).equals(s2p.get(word))) {
        return false;
      }
    }

    return !scanner.hasNext();
  }
}
// @lc code=end

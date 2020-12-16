/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (36.37%)
 * Likes:    4842
 * Dislikes: 213
 * Total Accepted:    574.9K
 * Total Submissions: 1.6M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given an m x n board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where "adjacent" cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 200
 * 1 <= word.length <= 10^3
 * board and word consists only of lowercase and uppercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
  private char[][] board;
  private String word;

  public boolean exist(char[][] board, String word) {
    if (board.length == 0) {
      return false;
    }

    this.board = board;
    this.word = word;

    for (var i = 0; i < board.length; ++i) {
      for (var j = 0; j < board[0].length; ++j) {
        if (dfs(0, i, j)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(int i, int x, int y) {
    if (i == word.length()) {
      return true;
    }

    if (x < 0
        || x >= board.length
        || y < 0
        || y >= board[0].length
        || board[x][y] != word.charAt(i)) {
      return false;
    }

    var temp = board[x][y];
    board[x][y] = '*';
    var res =
        dfs(i + 1, x - 1, y)
            || dfs(i + 1, x, y - 1)
            || dfs(i + 1, x + 1, y)
            || dfs(i + 1, x, y + 1);
    board[x][y] = temp;
    return res;
  }
}
// @lc code=end

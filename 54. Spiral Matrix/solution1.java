/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (35.12%)
 * Likes:    3176
 * Dislikes: 626
 * Total Accepted:    436.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 *
 */

// @lc code=start
class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new ArrayList<Integer>();
    }

    var left = 0;
    var top = 0;
    var right = matrix[0].length - 1;
    var bottom = matrix.length - 1;

    var res = new ArrayList<Integer>(matrix.length * matrix[0].length);

    while (true) {
      for (var i = left; i <= right; ++i) {
        res.add(matrix[top][i]);
      }
      if (++top > bottom) {
        break;
      }

      for (var i = top; i <= bottom; ++i) {
        res.add(matrix[i][right]);
      }
      if (--right < left) {
        break;
      }

      for (var i = right; i >= left; --i) {
        res.add(matrix[bottom][i]);
      }
      if (--bottom < top) {
        break;
      }

      for (var i = bottom; i >= top; --i) {
        res.add(matrix[i][left]);
      }
      if (++left > right) {
        break;
      }
    }

    return res;
  }
}
// @lc code=end

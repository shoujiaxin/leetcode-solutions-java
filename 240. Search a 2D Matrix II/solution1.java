/*
* @lc app=leetcode id=240 lang=java
*
* [240] Search a 2D Matrix II
*
* https://leetcode.com/problems/search-a-2d-matrix-ii/description/
*
* algorithms
* Medium (43.76%)
* Likes:    3924
* Dislikes: 84
* Total Accepted:    377.6K
* Total Submissions: 862.5K
* Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
 '5'
*
* Write an efficient algorithm that searches for a target value in an m x n
* integer matrix. The matrix has the following properties:
*
*
* Integers in each row are sorted in ascending from left to right.
* Integers in each column are sorted in ascending from top to bottom.
*
*
*
* Example 1:
*
*
* Input: matrix =
* [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
* target = 5
* Output: true
*
*
* Example 2:
*
*
* Input: matrix =
* [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
* target = 20
* Output: false
*
*
*
* Constraints:
*
*
* m == matrix.length
* n == matrix[i].length
* 1 <= n, m <= 300
* -10^9 <= matix[i][j] <= 10^9
* All the integers in each row are sorted in ascending order.
* All the integers in each column are sorted in ascending order.
* -10^9 <= target <= 10^9
*
*
*/

// @lc code=start
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    var n = matrix.length;
    if (n == 0) {
      return false;
    }
    var m = matrix[0].length;

    var row = n - 1;
    var col = 0;

    while (row >= 0 && col < m) {
      if (matrix[row][col] < target) {
        ++col;
      } else if (matrix[row][col] > target) {
        --row;
      } else {
        return true;
      }
    }

    return false;
  }
}
// @lc code=end

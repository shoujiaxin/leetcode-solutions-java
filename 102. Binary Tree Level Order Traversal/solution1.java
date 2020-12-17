/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (55.89%)
 * Likes:    3872
 * Dislikes: 94
 * Total Accepted:    727.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 *
 *
 * return its level order traversal as:
 *
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 *
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    var que = new LinkedList<TreeNode>();
    if (root != null) {
      que.add(root);
    }

    var res = new LinkedList<List<Integer>>();
    while (!que.isEmpty()) {
      var n = que.size();
      var nodes = new ArrayList<Integer>(n);

      for (var i = 0; i < n; ++i) {
        var node = que.poll();
        nodes.add(node.val);

        if (node.left != null) {
          que.add(node.left);
        }
        if (node.right != null) {
          que.add(node.right);
        }
      }

      res.add(nodes);
    }

    return res;
  }
}
// @lc code=end

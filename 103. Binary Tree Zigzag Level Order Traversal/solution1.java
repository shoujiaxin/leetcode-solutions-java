/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (49.48%)
 * Likes:    2864
 * Dislikes: 115
 * Total Accepted:    449.7K
 * Total Submissions: 907.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 *
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

      if (res.size() % 2 == 1) {
        Collections.reverse(nodes);
      }
      res.add(nodes);
    }

    return res;
  }
}
// @lc code=end

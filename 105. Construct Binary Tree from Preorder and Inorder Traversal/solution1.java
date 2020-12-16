/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (50.74%)
 * Likes:    4373
 * Dislikes: 113
 * Total Accepted:    429.4K
 * Total Submissions: 845.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }

    var rootVal = preorder[0];
    var root = new TreeNode(rootVal);

    var i = 0;
    for (; i < inorder.length; ++i) {
      if (inorder[i] == rootVal) {
        break;
      }
    }

    var leftPreorder = Arrays.copyOfRange(preorder, 1, i + 1);
    var leftInorder = Arrays.copyOfRange(inorder, 0, i);
    root.left = buildTree(leftPreorder, leftInorder);

    var rightPreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
    var rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
    root.right = buildTree(rightPreorder, rightInorder);

    return root;
  }
}
// @lc code=end

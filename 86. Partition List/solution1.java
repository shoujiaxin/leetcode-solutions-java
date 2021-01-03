/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (42.68%)
 * Likes:    1725
 * Dislikes: 347
 * Total Accepted:    241.1K
 * Total Submissions: 562.6K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 * Example:
 *
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    var dummyHead1 = new ListNode(0);
    var ptr1 = dummyHead1;
    var dummyHead2 = new ListNode(0);
    var ptr2 = dummyHead2;

    while (head != null) {
      if (head.val < x) {
        ptr1.next = head;
        head = head.next;
        ptr1 = ptr1.next;
        ptr1.next = null;
      } else {
        ptr2.next = head;
        head = head.next;
        ptr2 = ptr2.next;
        ptr2.next = null;
      }
    }

    ptr1.next = dummyHead2.next;
    return dummyHead1.next;
  }
}
// @lc code=end

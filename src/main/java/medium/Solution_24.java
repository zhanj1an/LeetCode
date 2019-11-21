package medium;

import model.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution_24 {
  public ListNode swapPairs(ListNode head) {
    ListNode res = new ListNode(-1);
    res.next = head;
    ListNode node = res;
    while (node.next != null && node.next.next != null) {
      ListNode temp = node.next.next;
      node.next.next = temp.next;
      temp.next = node.next;
      node.next = temp;
      node = node.next.next;
    }
    return res.next;
  }
}

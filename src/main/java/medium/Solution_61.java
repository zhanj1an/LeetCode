package medium;

import model.ListNode;

/**
 * 61. 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Solution_61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    if (head.next == null) return head;

    ListNode old_tail = head;
    int n;
    for (n = 1; old_tail.next != null; n++)
      old_tail = old_tail.next;
    old_tail.next = head;

    ListNode new_tail = head;
    for (int i = 0; i < n - k % n - 1; i++)
      new_tail = new_tail.next;
    ListNode new_head = new_tail.next;

    new_tail.next = null;

    return new_head;
  }

  public static void main(String[] args) {
    ListNode temp = new ListNode(-1);
    ListNode node = temp;
    for (int i = 1; i < 6; i++) {
      node.next = new ListNode(i);
      node = node.next;
    }
    temp = temp.next;

    Solution_61 solution = new Solution_61();
    ListNode res = solution.rotateRight(temp, 2);
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
  }
}

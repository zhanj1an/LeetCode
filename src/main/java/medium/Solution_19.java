package medium;

import model.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 */
public class Solution_19 {
  private static ListNode removeNthFromEnd(ListNode head, int n) {

//    双指针
//    ListNode dummy = new ListNode(0);
//    dummy.next = head;
//    ListNode first = dummy;
//    ListNode second = dummy;
//    for (int i = 1; i <= n + 1; i++) {
//      first = first.next;
//    }
//    while (first != null) {
//      first = first.next;
//      second = second.next;
//    }
//    second.next = second.next.next;
//    return dummy.next;


    ListNode res = new ListNode(-1);
    res.next = head;
    ListNode temp = res;
    int length = 0;
    while (temp.next != null) {
      length++;
      temp = temp.next;
    }

    ListNode temp2 = head;
    int count = 0;
    while (temp2.next != null){
      count++;
      if(count == length - n + 1){
        temp2.next = temp2.next.next;
      }else {
        temp2 = temp2.next;
      }
    }
    return res.next;
  }
}

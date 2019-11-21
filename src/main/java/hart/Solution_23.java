package hart;

import model.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution_23 {
  //暴力解法
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode res = new ListNode(-1);
    List<Integer> list = new ArrayList<>();

    for (ListNode listNode : lists) {
      ListNode node = listNode;
      while (node != null) {
        list.add(node.val);
        node = node.next;
      }
    }
    Collections.sort(list);
    ListNode temp = res;
    for (Integer integer : list) {
      temp.next = new ListNode(integer);
      temp = temp.next;
    }
    return res.next;
  }
}

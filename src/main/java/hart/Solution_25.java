package hart;

import model.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class Solution_25 {
  public ListNode reverseKGroup(ListNode head, int k) {

    //存list然后拼成结果 比较sb的方法 4ms
//    ListNode res = new ListNode(-1);
//    List<ListNode> nodes = new ArrayList<>();
//    ListNode listNode = res;
//
//    while (head != null){
//      ListNode temp = head;
//      head = head.next;
//      temp.next = null;
//      nodes.add(temp);
//    }
//
//    for (int i = 0; i < nodes.size(); i += k) {
//      if(nodes.size() - i < k){
//        break;
//      }
//      for (int j = 0; j < k / 2; j++) {
//        ListNode temp = nodes.get(i + j);
//        nodes.set(i + j, nodes.get(i + k - 1 - j));
//        nodes.set(i + k - 1 - j, temp);
//      }
//    }
//    for (ListNode node : nodes) {
//      listNode.next = node;
//      listNode = listNode.next;
//    }
//    return res.next;


    //使用栈 依然4ms
    ListNode res = new ListNode(-1);
    ListNode node = res;
    ListNode temp = head;

    Stack<ListNode> stack = new Stack<>();
    while (true){
      int count = 0;
      while (head != null && count < k) {
        stack.push(head);
        head = head.next;
        count++;
      }
      if (count != k){
        node.next = temp;
        break;
      }
      while (!stack.empty()) {
        node.next = stack.pop();
        node = node.next;
      }
      temp = head;
    }
    return res.next;
  }
}

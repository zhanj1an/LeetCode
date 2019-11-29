package hart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 32. 最长有效括号
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Solution_32 {
  public static int longestValidParentheses(String s) {
//    if (s.length() == 0 || s.length() == 1) {
//      return 0;
//    }
//    int res = 0;
//    Stack<String> stack = new Stack<>();
//    List<Integer> list = new ArrayList<>();
//    for (int i = 0; i < s.length(); i++) {
//      String str = s.charAt(i) + "";
//      if (stack.empty()) {
//        stack.push(str);
//        list.add(0);
//        continue;
//      }
//      if (str.equals("(")) {
//        stack.push(str);
//        list.add(0);
//      } else {
//        if (stack.peek().equals("(")) {
//          stack.pop();
//          list.add(1);
//        } else {
//          stack.push(str);
//          list.add(0);
//        }
//      }
//    }
//
//    int oneCount = 0;
//    for (int i = list.size() - 1; i >= 0; i--) {
//      if(list.get(i) == 1){
//        oneCount++;
//      }else{
//        if(oneCount > 0){
//          list.set(i, 1);
//          oneCount--;
//        }
//      }
//    }
//    int temp = 0;
//    for (Integer integer : list) {
//      if (integer == 1) {
//        temp++;
//      } else {
//        if (temp != 0) {
//          res = Math.max(temp, res);
//          temp = 0;
//        }
//      }
//    }
//    return Math.max(temp, res);

    //可以匹配的左右括号置为1，其他为0，找到最长的连续为1的长度
    //stack存储未使用的左括号
//    int res = 0;
//    List<Integer> list = new ArrayList<>();
//    Stack<Integer> stack = new Stack<>();
//    for (int i = 0; i < s.length(); i++) {
//      String str = s.charAt(i) + "";
//      if (str.equals("(")) {
//        stack.push(i);
//        list.add(0);
//      } else {
//        if (!stack.isEmpty()) {
//          list.set(stack.pop(), 1);
//          list.add(1);
//        } else {
//          list.add(0);
//        }
//      }
//    }
//    int temp = 0;
//    for (Integer integer : list) {
//      if (integer == 1) {
//        temp++;
//      } else {
//        if (temp != 0) {
//          res = Math.max(temp, res);
//          temp = 0;
//        }
//      }
//    }
//    return Math.max(temp, res);

    //将(下表压入栈，每次遇到)弹栈，当栈不为空 即有(匹配时计算最大长度，栈为空时为没有(匹配
//    int res = 0;
//    Stack<Integer> stack = new Stack<>();
//    stack.push(-1);
//    for (int i = 0; i < s.length(); i++) {
//      if (s.charAt(i) == '(') {
//        stack.push(i);
//      } else {
//        stack.pop();
//        if (stack.empty()) {
//          stack.push(i);
//        } else {
//          res = Math.max(res, i - stack.peek());
//        }
//      }
//    }
//    return res;

    //将数组中对应左括号下标的数设置为当前连续的括号数
    //       ( ) ( ( ) )
    //       0 1 2 3 4 5
    //array: 0 2 0 0 2 6
    int res = 0;
    int length = s.length();
    int[] array = new int[length];

    for (int i = 1; i < length; i++) {
      if(s.charAt(i) == ')'){
        if(s.charAt(i - 1) == '('){
          array[i] = i == 1 ? 2 : (array[i - 2] + 2);
        }else if(i - array[i - 1] > 0 && s.charAt(i - array[i - 1] - 1) == '('){
          //当i-1为)时，需要找到对应的(，并且加上对应(左边的连续数
          //解决当s = ()(())时array为020024问题，
          array[i] = (i - array[i - 1] == 1) ? array[i - 1] + 2 : array[i - array[i - 1] - 2] + array[i - 1] + 2;
        }
        res = Math.max(array[i], res);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("()(())"));
  }
}

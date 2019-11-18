package easy;

import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution_20 {
  private static boolean isValid(String s) {
    if (s.equals(""))
      return true;
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      String str = s.charAt(i) + "";
      if (str.equals("(") || str.equals("[") || str.equals("{")) {
        stack.push(s.charAt(i) + "");
      } else if (stack.empty()) {
        return false;
      } else if ((str.equals(")") && stack.peek().equals("(")) ||
              (str.equals("]") && stack.peek().equals("[")) ||
              (str.equals("}") && stack.peek().equals("{"))) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("(})"));
  }
}

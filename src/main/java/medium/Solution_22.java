package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Solution_22 {
  private static List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    handle(res, "", n, 0, 0);
    return res;
  }

  private static void handle(List<String> res, String temp, int n, int left, int right){
    if(left == n && right == n){
      res.add(temp);
    }

    if(left < n){
      handle(res, temp + "(", n, left + 1, right);
    }
    if(right < left && right < n){
      handle(res, temp + ")", n, left, right + 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(generateParenthesis(3));
  }
}

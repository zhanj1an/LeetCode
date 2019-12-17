package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 60.第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Solution_60 {
  //康托展开
  public String getPermutation(int n, int k) {
    char[] result = new char[n];
    List<Integer> nums = new ArrayList<>();
    int[] factorial = new int[n];
    factorial[0] = 1;
    for (int i = 1; i < n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }
    k--;
    for (int i = 0; i < n; i++) {
      result[i] = Character.forDigit(nums.remove(k / factorial[n - 1 - i]), 10);
      k = k % factorial[n - 1 - i];
    }
    return new String(result);
  }

  public static void main(String[] args) {
    Solution_60 solution = new Solution_60();
    System.out.println(solution.getPermutation(3, 3));
  }
}

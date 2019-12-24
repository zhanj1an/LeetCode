package easy;

/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Solution_69 {
  public int mySqrt(int x) {
    long left = 0;
    long right = x / 2 + 1;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
        return (int)mid;
      } else if (mid * mid > x) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Solution_69 solution = new Solution_69();
    System.out.println(solution.mySqrt(10));
  }
}

package easy;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 1阶 1种
 * 2阶 2种
 * 3阶 3种
 * 4阶 5种
 * 5阶 8种
 * 斐波那契数列
 */
public class Solution_70 {
  public int climbStairs(int n) {
    //斐波那契数列
//    if (n == 1)
//      return 1;
//    int i = 1;
//    int j = 2;
//    for (int k = 3; k <= n; k++) {
//      int temp = j + i;
//      i = j;
//      j = temp;
//    }
//    return j;

    //n阶高度方法等于 n-1阶 + n-2阶
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 2;

    for (int i = 2; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
  }
}

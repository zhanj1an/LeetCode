package hart;

/**
 * 42. 接雨水
 * link:https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class Solution_42 {
  public int trap(int[] height) {
    int len = height.length;
    if (len < 3) {
      return 0;
    }
    int res = 0;
    int leftMax = height[0];
    int rightMax = height[len - 1];
    int left = 1;
    int right = len - 2;
    while (left <= right) {
      int minVal = Math.min(leftMax, rightMax);
      if (minVal == leftMax) {
        if (minVal > height[left]) {
          res += minVal - height[left];
        }
        leftMax = Math.max(leftMax, height[left]);
        left++;
      } else {
        if (minVal > height[right]) {
          res += minVal - height[right];
        }
        rightMax = Math.max(rightMax, height[right]);
        right--;
      }
    }
    return res;
  }
}

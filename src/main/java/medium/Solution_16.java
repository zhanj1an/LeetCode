package medium;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution_16 {

  public static int threeSumClosest(int[] nums, int target) {
    if (nums.length == 3)
      return nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    int res = Integer.MAX_VALUE / 2;
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int temp = nums[i] + nums[left] + nums[right];
        if (target == temp)
          return target;
        if (Math.abs(temp - target) < Math.abs(res - target)) {
          res = temp;
        }
        if (temp > target)
          right--;
        if (temp < target)
          left++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[]{-2, -3, 3, -4, -5}, -1));
  }
}

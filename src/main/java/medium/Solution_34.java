package medium;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution_34 {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = findFirst(nums, target);
    res[1] = findLast(nums, target);
    return res;
  }

  private int findLast(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] > target) {
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        if ((mid == nums.length - 1) || (nums[mid + 1] != target)) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }

  private int findFirst(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] > target) {
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        if ((mid == 0) || (nums[mid - 1] != target)) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}

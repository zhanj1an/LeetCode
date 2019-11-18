package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Solution_18 {
  private static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 4)
      return res;
    Arrays.sort(nums);
    int length = nums.length;
    //最小值大于target
    if (nums[0] + nums[1] + nums[2] + nums[3] > target)
      return res;
    //最大值小于target
    if (nums[length - 1] + nums[length - 2] + nums[length - 2] + nums[length - 2] < target)
      return res;
    for (int j = 0; j < length - 3; j++) {
      //去重
      if(j > 0 && nums[j] == nums[j - 1])
        continue;
      //当前最大值小于target
      if (nums[j] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target)
        continue;
      //当前最小值大于target
      if(nums[j] + nums[j + 1] + nums[j + 2] + nums[j + 3] > target)
        break;
      for (int i = j + 1; i < length - 2; i++) {
        if(nums[i] == nums[i - 1] && i > j + 1)
          continue;
        //当前最大值小于target
        if (nums[j] + nums[i] + nums[length - 1] + nums[length - 2] < target)
          continue;
        //当前最小值大于target
        if(nums[j] + nums[i] + nums[j + 1] + nums[j + 2] > target)
          break;
        int left = i + 1;
        int right = length - 1;
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right] + nums[j];
          if (sum == target) {
            res.add(Stream.of(nums[j], nums[i], nums[left], nums[right]).collect(Collectors.toList()));
            while (left < right && nums[left] == nums[left + 1])
              left++;
            while (left < right && nums[right] == nums[right - 1])
              right--;
            left++;
            right--;
          }
          if (sum < target)
            left++;
          if (sum > target)
            right--;
        }
      }
    }
    return res;
  }
  public static void main(String[] args) {
    System.out.println(fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4));
  }
}

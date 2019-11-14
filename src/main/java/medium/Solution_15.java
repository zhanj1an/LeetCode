package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 15. 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * [-4，-1, -1, 0, 1, 2]
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution_15 {
  private static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if(nums == null || nums.length < 3)
      return res;
    Arrays.sort(nums);
    int length = nums.length;
    for (int i = 0; i < length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      if (nums[i] > 0)
        break;
      int left = i + 1;
      int right = length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          res.add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
          while (left < right && nums[left] == nums[left + 1])
            left++;
          while (left < right && nums[right] == nums[right - 1])
            right--;
          left++;
          right--;
        }
        if (sum < 0)
          left++;
        if (sum > 0)
          right--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
  }

}

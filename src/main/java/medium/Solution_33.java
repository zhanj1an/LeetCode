package medium;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * <p>
 * 4 5 6 7 8 1 2
 */
public class Solution_33 {
  //两次二分查找 一次找分界点 一次找指
  public static int search(int[] nums, int target) {
    if (nums.length == 0)
      return -1;
    if (nums.length == 1)
      return nums[0] == target ? 0 : -1;
    if (target < nums[0] && target > nums[nums.length - 1])
      return -1;
    int length = nums.length;
    int begin = 0;
    int end = length - 1;
    int mid = 0;
    boolean flag = false;
    while (begin < end) {
      mid = (end + begin) / 2;
      int temp = nums[mid];
      if (temp > nums[mid + 1]) {
        flag = true;
        break;
      }
      if (temp > nums[0]) {
        begin = mid + 1;
        continue;
      }
      end = mid;
    }
    if(flag) {
      if (target >= nums[0]) {
        begin = 0;
        end = mid;
      } else {
        begin = mid + 1;
        end = length - 1;
      }
    }else{
      begin = 0;
      end = length - 1;
    }
    while (begin <= end) {
      mid = (end + begin) / 2;
      int temp = nums[mid];
      if (temp == target) {
        return mid;
      }
      if (temp < target) {
        begin = mid + 1;
      }
      if (temp > target) {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{5 ,1, 3}, 5));
  }
}

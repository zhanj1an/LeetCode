package hart;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class Solution_41 {
  public static int firstMissingPositive(int[] nums) {
//    if(nums.length == 0)
//      return 1;
//    int count = 0;
//    Arrays.sort(nums);
//    int i = 0;
//    for (; i < nums.length; i++) {
//      if(nums[i] <= 0 || (i > 0 && nums[i] == nums[i - 1])){
//        count++;
//      }else{
//        if(count == 0 && i + 1 != nums[i]){
//          return i + 1;
//        }
//        if(i - count + 1 != nums[i]){
//          return i - count + 1;
//        }
//      }
//    }
//    if(count == 0){
//      return i + 1;
//    }else{
//      return i - count + 1;
//    }

    boolean[] isExist = new boolean[nums.length];
    for (int num : nums) {
      if (num <= 0 || num > nums.length)
        continue;
      isExist[num] = true;
    }

    int temp = 1;
    while(temp <= nums.length && isExist[temp]){
      temp++;
    }
    return temp;
  }

  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[] {0, 1, 1, 2, 2}));
  }
}

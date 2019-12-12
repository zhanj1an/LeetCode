package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Solution_47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] selected = new boolean[nums.length];
    Arrays.sort(nums);
    handle(res, temp, selected, nums);
    return res;
  }

  public void handle(List<List<Integer>> res, List<Integer> temp, boolean[] selected, int[] nums) {
    if (temp.size() == selected.length) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < selected.length; i++) {
      if (selected[i] || (i > 0 && !selected[i - 1] && nums[i] == nums[i - 1]))
        continue;
      temp.add(nums[i]);
      selected[i] = true;
      handle(res, temp, selected, nums);
      temp.remove(temp.size() - 1);
      selected[i] = false;
    }
  }

  public static void main(String[] args) {
    Solution_47 solution = new Solution_47();
    System.out.println(solution.permuteUnique(new int[]{3, 3, 0}));
  }
}

package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution_46 {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] selected = new boolean[nums.length];
    handle(res, temp, selected, nums);
    return res;
  }

  public void handle(List<List<Integer>> res, List<Integer> temp, boolean[] selected, int[] nums) {
    if (temp.size() == selected.length) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < selected.length; i++) {
      if (selected[i])
        continue;
      temp.add(nums[i]);
      selected[i] = true;
      handle(res, temp, selected, nums);
      temp.remove(temp.size() - 1);
      selected[i] = false;
    }
  }

  public static void main(String[] args) {
    Solution_46 solution = new Solution_46();
    System.out.println(solution.permute(new int[]{1, 2, 3}));
  }
}

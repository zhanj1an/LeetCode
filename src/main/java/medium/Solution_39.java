package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution_39 {

  private List<List<Integer>> res = new ArrayList<>();
  private int[] candidates;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    this.candidates = candidates;
    findCombinationSum(target, 0, new Stack<>());
    return res;
  }

  private void findCombinationSum(int residue, int start, Stack<Integer> stack) {
    if (residue == 0) {
      res.add(new ArrayList<>(stack));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (residue - candidates[i] >= 0) {
        stack.push(candidates[i]);
        findCombinationSum(residue - candidates[i], i, stack);
        stack.pop();
      }
    }
  }

  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    int target = 8;
    Solution_39 solution = new Solution_39();
    List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
    System.out.println(combinationSum);
  }
}

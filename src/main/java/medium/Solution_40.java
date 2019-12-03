package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 40. 组合总和2
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class Solution_40 {

  private List<List<Integer>> res = new ArrayList<>();
  private int[] candidates;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
    if(start == candidates.length - 1)
      return;
    int temp = candidates[start] - 1;
    for (int i = start; i < candidates.length; i++) {
      if (residue - candidates[i] >= 0) {
        //在递归中如果弹出元素和当前获取元素相等continue，去重
        if(temp != candidates[i]){
          temp = candidates[i];
        }else {
          continue;
        }
        stack.push(candidates[i]);
        //元素不可以重复使用 所以start为i+1
        findCombinationSum(residue - candidates[i], i + 1, stack);
        stack.pop();
      }
    }
  }

  public static void main(String[] args) {
    int[] candidates = {10,1,2,7,6,1,5};
    int target = 8;
    Solution_40 solution = new Solution_40();
    List<List<Integer>> combinationSum = solution.combinationSum2(candidates, target);
    System.out.println(combinationSum);
  }
}

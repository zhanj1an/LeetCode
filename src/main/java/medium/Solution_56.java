package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution_56 {
  public int[][] merge(int[][] intervals) {
    List<int[]> list = new ArrayList<>();
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });

    int i = 0;
    int n = intervals.length;
    while (i < n) {
      int left = intervals[i][0];
      int right = intervals[i][1];
      while (i < n - 1 && right >= intervals[i + 1][0]) {
        right = Math.max(right, intervals[i + 1][1]);
        i++;
      }
      list.add(new int[]{left, right});
      i++;
    }
    return list.toArray(new int[list.size()][2]);
  }

  public static void main(String[] args) {
    Solution_56 solution = new Solution_56();
    int[][] intervals = new int[][]{{1, 4}, {2, 3}};
    int[][] res = solution.merge(intervals);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i][0] + " " + res[i][1]);
    }
  }
}

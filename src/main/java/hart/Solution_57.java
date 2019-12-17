package hart;

import medium.Solution_56;

import java.util.ArrayList;
import java.util.List;

/**
 * 57.插入区间
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution_57 {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int[] lastInterval = null;
    int i = 0;
    for (; i < intervals.length; i++) {
      if (newInterval[0] < intervals[i][0]) {
        // 新区间的start比当前区间的start要小，则插入新区间
        lastInterval = addOrUpdate(result, lastInterval, newInterval);
        break;
      }
      lastInterval = addOrUpdate(result, lastInterval, intervals[i]);
    }
    if (i == intervals.length) {
      // 将新区间添加到最后
      addOrUpdate(result, lastInterval, newInterval);
    } else {
      // 新区间已插入，添加后续的区间
      for (; i < intervals.length; i++) {
        lastInterval = addOrUpdate(result, lastInterval, intervals[i]);
      }
    }
    return result.toArray(new int[0][]);
  }

  private int[] addOrUpdate(List<int[]> result, int[] lastInterval, int[] newInterval) {
    if (lastInterval == null || lastInterval[1] < newInterval[0]) {
      lastInterval = newInterval;
      result.add(newInterval);
    } else if (lastInterval[1] < newInterval[1]) {
      lastInterval[1] = newInterval[1];
    }
    return lastInterval;
  }

  public static void main(String[] args) {
    Solution_57 solution = new Solution_57();
    int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[][] res = solution.insert(intervals, new int[]{4, 8});
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i][0] + " " + res[i][1]);
    }
  }
}

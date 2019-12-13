package medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution_54 {
  //一层一层遍历 count为层数
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix.length == 0)
      return res;
    int count = 0;
    int col = matrix.length;
    int row = matrix[0].length;
    while (2 * count < col && 2 * count < row) {
      if (col - 2 * count == 1) {
        for (int i = count; i < row - count; i++) {
          res.add(matrix[count][i]);
        }
        return res;
      }
      if (row - 2 * count == 1) {
        for (int i = count; i < col - count; i++) {
          res.add(matrix[i][count]);
        }
        return res;
      }
      for (int i = count; i < row - 1 - count; i++) {
        res.add(matrix[count][i]);
      }
      for (int i = count; i < col - 1 - count; i++) {
        res.add(matrix[i][row - count - 1]);
      }
      for (int i = row - 1 - count; i > count; i--) {
        res.add(matrix[col - count - 1][i]);
      }
      for (int i = col - 1 - count; i > count; i--) {
        res.add(matrix[i][count]);
      }
      count++;
    }
    return res;
  }


  public static void main(String[] args) {
//    int[][] matrix = new int[][]{{2,3,4}, {5,6,7}, {8,9,10}, {11,12,13}, {14,15,16}};
//    int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int[][] matrix = new int[][]{{2, 3}};
    Solution_54 solution = new Solution_54();
    System.out.println(solution.spiralOrder(matrix));
  }
}

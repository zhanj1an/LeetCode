package medium;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class Solution_73 {
  public void setZeroes(int[][] matrix) {
    int rowLength = matrix.length;
    int colLength = matrix[0].length;

    //获得需要置0的行和列
    boolean[] row = new boolean[rowLength];
    boolean[] col = new boolean[colLength];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0){
          row[i] = true;
          col[j] = true;
        }
      }
    }

    //行置0
    for (int i = 0; i < row.length; i++) {
      if (row[i]){
        Arrays.fill(matrix[i], 0);
      }
    }

    //列置0
    for (int i = 0; i < col.length; i++) {
      if (col[i]){
        for (int j = 0; j < rowLength; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{0}, {1}};
    Solution_73 solution = new Solution_73();
    solution.setZeroes(matrix);
    for (int[] ints : matrix) {
      for (int anInt : ints) {
        System.out.print(anInt + " ");
      }
      System.out.println();
    }
  }
}

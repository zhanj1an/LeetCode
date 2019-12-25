package medium;

/**
 * 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Solution_74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int rowLength = matrix.length;
    int colLength = matrix[0].length;

    if (target < matrix[0][0] || target > matrix[rowLength - 1][colLength - 1]) {
      return false;
    }

    for (int[] ints : matrix) {
      if (target >= ints[0] && target <= ints[colLength - 1]) {
        //二分查找
        int left = 0;
        int right = colLength - 1;
        while (left <= right) {
          int mid = (left + right) / 2;
          if (ints[mid] == target) {
            return true;
          } else if (ints[mid] < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        break;
      }
    }
    return false;
  }
}

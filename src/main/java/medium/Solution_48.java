package medium;

/**
 * 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Solution_48 {
  public void rotate(int[][] matrix) {
    int length = matrix.length;
    //一层一层循环，count为层数
    int count = 0;
    while (length - count * 2 > 1) {
      for (int i = count; i < length - count - 1; i++) {
        int temp = matrix[count][i];
        matrix[count][i] = matrix[length - i - 1][count];
        matrix[length - i - 1][count] = matrix[length - count - 1][length - i - 1];
        matrix[length - count - 1][length - i - 1] = matrix[i][length - count - 1];
        matrix[i][length - count - 1] = temp;
      }
      count++;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
//    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Solution_48 solution = new Solution_48();
    solution.rotate(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}

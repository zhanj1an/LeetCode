package medium;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 输入: 4
 * 输出:
 * [
 *  [  1,  2,  3, 4 ],
 *  [ 12, 13, 14, 5 ],
 *  [ 11, 16, 15, 6 ],
 *  [ 10,  9,  8, 7 ],
 */
public class Solution_59 {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int count = 0;
    int num = 1;
    while (count < n / 2 + n % 2){
      for (int i = count; i < n - count; i++) {
        res[count][i] = num++;
      }

      for (int i = count + 1; i < n - count; i++) {
        res[i][n - count - 1] = num++;
      }

      for (int i = n - count - 2; i >= count; i--) {
        res[n - count - 1][i] = num++;
      }

      for (int i = n - count - 2; i > count; i--) {
        res[i][count] = num++;
      }
      count++;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution_59 solution = new Solution_59();
    int n = 5;
    int[][] res = solution.generateMatrix(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }
}

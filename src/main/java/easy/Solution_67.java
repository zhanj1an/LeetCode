package easy;

/**
 * 67. 二进制求和
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution_67 {
  public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    String longer = a.length() >= b.length() ? a : b;
    String shorter = a.length() < b.length() ? a : b;
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < longer.length() - shorter.length(); i++) {
      temp.append("0");
    }
    shorter = temp + shorter;

    int length = longer.length();
    boolean flag = false;
    for (int i = length - 1; i >= 0; i--) {
      int sum = longer.charAt(i) - 48 + shorter.charAt(i) - 48;
      if (flag) {
        sum++;
      }
      if (sum >= 2) {
        res.insert(0, sum % 2);
        flag = true;
      } else {
        res.insert(0, sum);
        flag = false;
      }
    }
    if (flag){
      res.insert(0, 1);
    }
    return res.toString();
  }


  public static void main(String[] args) {
    Solution_67 solution = new Solution_67();
    System.out.println(solution.addBinary("11", "1"));
  }

}

package medium;

/**
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution_5 {
  public static String longestPalindrome(String s) {
    if ("".equals(s))
      return "";
    if (s.length() == 1)
      return s;

    boolean[][] dp = new boolean[s.length()][s.length()];

    int maxLength = 1;
    String res = s.substring(0, 1);

    for (int i = 1; i < s.length(); i++) {
      for (int j = i; j >= 0; j--) {
        //i - 1 <= j + 1情况包括 a, aa, bab; 否则为baab
        if (s.charAt(i) == s.charAt(j) && (i - 1 <= j + 1 || dp[j + 1][i - 1])) {
          dp[j][i] = true;
          if (maxLength < i - j + 1) {
            maxLength = i - j + 1;
            res = s.substring(j, i + 1);
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("abcba"));
  }
}

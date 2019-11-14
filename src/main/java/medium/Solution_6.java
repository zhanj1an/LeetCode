package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution_6 {
  private static String convert(String s, int numRows) {
    if("".equals(s)){
      return "";
    }
    if(numRows == 1){
      return s;
    }
    String[] strings = new String[numRows];
    for (int i = 0; i < numRows; i++) {
      strings[i] = "";
    }
    char[] chars = s.toCharArray();
    int index = 0;
    boolean flag = true;
    for (char aChar : chars) {
      strings[index] += (aChar + "");
      if (index == numRows - 1) {
        flag = false;
      }
      if (index == 0) {
        flag = true;
      }
      if (flag) {
        index++;
      } else {
        index--;
      }
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      if(strings[i] == null)
        break;
      res.append(strings[i]);
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(convert("A", 2));
  }
}

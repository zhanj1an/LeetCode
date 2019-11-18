package medium;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 2:abc 3:def 4:ghi 5:jkl 6:mno 7:pqrs 8:tuv 9:wxyz
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class Solution_17 {

  private static List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    map.put("2", "abc");
    map.put("3", "def");
    map.put("4", "ghi");
    map.put("5", "jkl");
    map.put("6", "mno");
    map.put("7", "pqrs");
    map.put("8", "tuv");
    map.put("9", "wxyz");
    char[] chars = digits.toCharArray();
    for (char aChar : chars) {
      if(map.containsKey(aChar + ""))
        handleList(res, map.get(aChar + ""));
    }
    return res;
  }

  private static void handleList(List<String> res, String input){
    if(res.size() == 0){
      for (int i = 0; i < input.length(); i++) {
        res.add(input.charAt(i) + "");
      }
    }else{
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < res.size(); i++) {
        for (int j = 0; j < input.length(); j++) {
          temp.add(i, res.get(i) + input.charAt(j));
        }
      }
      res.clear();
      res.addAll(temp);
    }
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("234"));
  }
}

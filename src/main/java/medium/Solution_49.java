package medium;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution_49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);
      if (map.containsKey(key)) {
        map.get(key).add(str);
      } else {
        //使用Stream速度比直接new List慢了一倍
//        map.put(key, Stream.of(str).collect(Collectors.toList()));
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(key, list);
      }
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Solution_49 solution = new Solution_49();
    System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }
}

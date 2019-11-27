package hart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class Solution_30 {
  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    if("".equals(s) || words.length == 0)
      return res;
    int wordLength = words[0].length();
    int wordsLength = words.length * wordLength;
    for (int i = 0; i <= s.length() - wordsLength; i+=wordLength) {
      List<String> temp = Stream.of(words).collect(Collectors.toList());
      int index = i;
      int count = 0;
      while (count < words.length) {
        String substring;
        if(index + wordLength != s.length()){
          substring = s.substring(index, index + wordLength);
        }else{
          substring = s.substring(index);
        }
        if(!temp.contains(substring)){
          break;
        } else{
          temp.remove(substring);
        }
        index += wordLength;
        count++;
      }
      if(temp.isEmpty())
        res.add(i);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
  }
}

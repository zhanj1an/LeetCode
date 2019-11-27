package easy;

/**
 * 28. 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution_28 {
  public static int strStr(String haystack, String needle) {
    if (haystack == null) {
      return -1;
    }
    if (needle == null || needle.length() == 0) {
      return 0;
    }
    if (needle.length() > haystack.length()) {
      return -1;
    }
    //haystack指针
    int i = 0;
    //needle指针
    int j = 0;
    int temp = -1;
    while (i < haystack.length() && j < needle.length()) {
      //判断剩余长度是否大于needle长度
      if (j == 0 && needle.length() > haystack.length() - i)
        return -1;
      //当字段匹配
      if (haystack.charAt(i) == needle.charAt(j)) {
        //当字符串开头相等时首先判断结尾是否相等，不相等不改变j进行比较，有此判断执行时间1ms，没有4ms
        if (j == 0 && haystack.charAt(i + needle.length() - 1) != needle.charAt(needle.length() - 1)) {
          i++;
          continue;
        }
        //记录在匹配过程中与needle[0]相同的index，匹配不成功下次从这里开始遍历
        if (temp == -1 && haystack.charAt(i) == needle.charAt(0)) {
          temp = i;
        }
        //当全部匹配成功时返回
        if (j == needle.length() - 1) {
          return i - j;
        }
        j++;
      }
      //匹配不成功时，从temp处开始遍历
      else {
        if (temp != -1) {
          i = temp;
          temp = -1;
        }
        j = 0;
      }
      i++;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("hello", "ll"));
  }
}

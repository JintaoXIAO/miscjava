package algos.misc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class Lt32 {
  public static void main(String[] args) {
    var s = new Lt32().new Solution();
    Stream.of(
        "(",
        ")",
        "(()",
        ")()())",
        "()()(()())())",
        "()(()()"
    ).forEach(it -> {
      System.out.println(it + ": " + s.longestValidParentheses(it));
    });
  }

  class Solution {
    public int longestValidParentheses(String s) {
      int[] status = new int[s.length()];
      int balance = 0;
      // left scan
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') balance ++;
        else {
          balance --;
          if (balance < 0) {
            status[i] = 1;
            balance = 0;
          }
        }
      }
      // right scan
      balance = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ')') balance ++;
        else {
          balance --;
          if (balance < 0) {
            status[i] = 1;
            balance = 0;
          }
        }
      }

      // count
      int max = 0;
      int len = 0;
      for (int i = 0; i < status.length; i++) {
        while (i < status.length && status[i] == 0) {
          len++;
          i++;
        }
        if (max < len) max = len;
        len = 0;
      }
      return max;
    }
  }
}

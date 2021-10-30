package algos.misc;

import java.util.*;

public class Lt49 {

  public static void main(String[] args) {
    var result = new Lt49().new Solution().groupAnagrams(new String[]{
        "eat", "tea", "tan", "ate", "nat", "bat"
    });
    System.out.println(result);
  }

  class Solution {
    String encode(String word) {
      char base = 'a';
      byte[] encoder = new byte[26];

      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        encoder[c - base] ++;
      }
      return Arrays.toString(encoder);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> groups = new HashMap<>();
      for (String word : strs) {
        String e = encode(word);
        groups.computeIfAbsent(e, (ignore) -> new ArrayList<>());
        groups.get(e).add(word);
      }
      List<List<String>> result = new ArrayList<>();
      result.addAll(groups.values());
      return result;
    }
  }
}

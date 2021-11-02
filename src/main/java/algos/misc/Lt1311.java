package algos.misc;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lt1311 {

  public static void main(String[] args) {
    var t = new Lt1311().new Solution();
    var r = t.watchedVideosByFriends(List.of(
            List.of("A", "B"),List.of("C"), List.of("B", "C"), List.of("D")
    ), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 2);
    System.out.println(r);
  }


  class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
      Set<Integer> ids = new HashSet<>();
      ids.add(id);

      // friend id :: level of relation with user
      Map<Integer, Integer> relations = new HashMap<>();
      relations.put(id, 0);

      int currentLevel = 1;
      Set<Integer> medianFriends = new HashSet<>();

      while (currentLevel <= level) {
        for (int cid: ids) {
          for (int friend: friends[cid]) {
            relations.putIfAbsent(friend, currentLevel);
            medianFriends.add(friend);
          }
        }
        ids.clear();
        ids.addAll(medianFriends);
        medianFriends.clear();;

        currentLevel ++;
      }

      return relations.entrySet().stream().filter(e -> e.getValue() == level)
              .map(Map.Entry::getKey)
              .flatMap(k -> watchedVideos.get(k).stream())
              .collect(Collectors.toMap(Function.identity(), v -> 1, (integer, integer2) -> integer + integer2))
              .entrySet().stream().sorted((o1, o2) -> o1.getValue() > o2.getValue()
                      ? 1
                      : o1.getValue() < o2.getValue()
                      ? -1
                      : o1.getKey().compareTo(o2.getKey()))
              .map(Map.Entry::getKey)
              .collect(Collectors.toList());

    }
  }
}

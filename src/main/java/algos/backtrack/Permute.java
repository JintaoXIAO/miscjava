package algos.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permute {
  public static void main(String[] args) {
    var p = new Permute();
    var r = p.permute(new int[]{1, 2, 3});
    System.out.println(r);

  }

  List<List<Integer>> permute(int[] nums) {
    var result = new LinkedList<List<Integer>>();
    var track = new LinkedList<Integer>();
    backtrack(nums, track, result);
    return result;
  }

  void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
    if (track.size() == nums.length) {
      result.add(new LinkedList<>(track));
      return;
    }

    for (int n : nums) {
      if (!track.contains(n)) {
        track.add(n);
        backtrack(nums, track, result);
        track.removeLast();
      }
    }
  }
}

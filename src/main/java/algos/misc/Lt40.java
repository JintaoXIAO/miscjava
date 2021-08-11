package algos.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lt40 {
  public static void main(String[] args) {
    algos.misc.Lt40.Solution s = new Lt40().new Solution();
    int[] arr = new int[]
            {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};

/*
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
*/

    //{2, 5, 2, 1, 2};
    //{10, 1, 2, 7, 6, 1, 5};
    int target = 27;
    var result = s.combinationSum2(arr, target);
    System.out.println(result);
  }
  class Solution {

    /*
    f([1,1,2,5,6,7,10], 8) =
      - f([1,2,5,6,7], 7)
      - f([1,2,5,6,7], 8)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<List<Integer>> result = new ArrayList<>();
      f(candidates, 0, target, new ArrayList<>(), result);
      return result;
    }

    private void f(int[] arr, int i, int target, List<Integer> tmp, List<List<Integer>> result) {
      // fail fast
      if (i == arr.length || arr[i] > target) return;

      if (arr[i] == target) {
        tmp.add(arr[i]);
        result.add(tmp);
        return;
      }
      // skip repeat values
      int j = i+1;
      while (j<arr.length && arr[j] == arr[i] ) {
        j ++;
      }
      f(arr, j, target, clone(tmp), result);

      // include current value
      List<Integer> l = clone(tmp);
      l.add(arr[i]);
      f(arr, i + 1, target - arr[i], l, result);

    }

    private List<Integer> clone(List<Integer> lst) {
      return new ArrayList<>(lst);
    }
  }
}

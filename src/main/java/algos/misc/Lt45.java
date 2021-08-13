package algos.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lt45 {
  public static void main(String[] args) {
    var s = new
            Lt45().new Solution();
    int[][] arr = new int[][]{

            {2, 3, 1, 1, 4},
            {2, 3, 0, 1, 4},
            {5, 6, 4, 4, 6, 9,
                    4, 4, 7, 4, 4, 8, 2, 6, 8,
                    1, 5, 9, 6, 5, 2, 7, 9,
                    7, 9, 6, 9, 4, 1, 6,
                    8, 8, 4, 4, 2, 0, 3, 8, 5},
            {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3},
    };
    Arrays.stream(arr).forEach(a -> {
      int jump = s.jump(a);
      System.out.println(jump);
    });
  }
  class Solution {
    public int jump(int[] nums) {
      return f(nums, 0);
    }

    int f(int[] nums, int i){
      if (nums.length - 1 == i) return 0;
      if (nums[i] + i >= nums.length - 1) return 1;
      int maxDistance = 0;
      int nextPosition = i;
      for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
        if (j + nums[j] >= nums.length - 1) {
          nextPosition = j;
          break;
        } else if (j + nums[j] > maxDistance) {
          maxDistance = j + nums[j];
          nextPosition = j;
        }
      }
      return 1 + f(nums, nextPosition);
    }
  }

  class Solution1 {
    public int jump(int[] nums) {
      return f(nums, 0);
    }

    int f(int[] nums, int i) {
      if (nums.length - 1 == i) return 0;
      int s = nums[i];
      List<Integer> jumps = new ArrayList<>();

      if (s == 0){
        return 10_000; //1 <= nums.length <= 10^4
      }
      for (int j = 1; j <= s && i + j < nums.length; j++) {
        jumps.add(1 + f(nums, i + j));
      }
      return jumps.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
  }
}

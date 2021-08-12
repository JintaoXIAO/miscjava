package algos.misc;

import java.util.Arrays;

public class Lt41 {

  public static void main(String[] args) {
    var s = new Lt41().new Solution2();
    int[][] quizs = new int[][]{
            {1,2,0},
            {1},
            {1,2,3,10,2147483647,9},
    };
    Arrays.stream(quizs)
            .map(s::firstMissingPositive)
            .forEach(System.out::println);
  }

  // swap
  class Solution2 {
    public int firstMissingPositive(int[] nums) {
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] < n + 1 && nums[nums[i] - 1] != nums[i]) {
          int t = nums[nums[i] - 1];
          nums[nums[i] - 1] = nums[i];
          nums[i] = t;
        }
      }
      for (int i = 0; i < n; i++) {
        if (nums[i] != i + 1) {
          return i + 1;
        }
      }
      return n + 1;
    }
  }


  // mark
  class Solution1 {
    public int firstMissingPositive(int[] nums) {
      // 1. tidying
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        if (nums[i] < 1 || nums[i] > n) {
          nums[i] = n + 1;
        }
      }

      // 2. mark
      for (int i = 0; i < n; i++) {
        if (nums[i] < n + 1 && nums[nums[i] - 1] > 0) {
          nums[nums[i] - 1] = -nums[nums[i] - 1];
        }
      }
      // 3. search
      for (int i = 0; i < n; i++) {
        if (nums[i] > 0) {
          return i + 1;
        }
      }
      return n + 1;
    }
  }

  class Solution {
    public int firstMissingPositive(int[] nums) {
      int[] minmax = minmax(nums);
      if (minmax[0] > 1) return 1;

      int maxsize = (int) Math.pow(5,6);
      BitMap bm = new BitMap(maxsize + 1);
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) bm.add(nums[i]);
      }

      int i = 1;
      while (i < minmax[1]) {
        if (!bm.contains(i))
          return i;
        i++;
      }
      return i + 1;
    }
    class BitMap {
      private int[] bits;
      public BitMap(int n) {
        this.bits = new int[n];
      }
      public void add(int i) {
        if ((i / 32) >= bits.length) return;
        bits[i / 32] |= 1 << ((i % 32) - 1);
      }

      public boolean contains(int i) {
        return ((bits[i / 32] >> ((i % 32) - 1)) & 1) == 1;
      }
     }
    private int[] minmax(int[] arr) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] > 0){
          if (arr[i] < min) min = arr[i];
          if (arr[i] > max) max = arr[i];
        }
      }
      return new int[]{min, max};
    }
  }
}

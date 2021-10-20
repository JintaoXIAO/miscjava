package algos.misc;

public class Lt53 {
  /*
  [-2,1,-3,4,-1,2,1,-5,4]

   */


  class Solution {
    public int maxSubArray(int[] nums) {
      int max = Integer.MIN_VALUE;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum < nums[i]) sum = nums[i];

        if (max < sum) max = sum;
      }
      return max;
    }
  }
}

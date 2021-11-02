package algos.misc;

import java.util.ArrayList;
import java.util.List;

public class Lt229 {
  class Solution {
    public List<Integer> majorityElement(int[] nums) {
      if (nums == null || nums.length == 0) return List.of();
      if (nums.length == 1) return List.of(nums[0]);

      int m1 = nums[0];
      int m2 = m1;
      for (int num : nums) {
        if (num != m1) {
          m2 = num;
          break;
        }
      }

      int c1 = 0;
      int c2 = 0;

      for (int num : nums) {

        if ((c1 == 0 || m1 == num) && num != m2) {
          m1 = num;
          c1++;

        } else if (c2 == 0 || m2 == num) {
          m2 = num;
          c2++;

        } else {
          c2--;
          c1--;
        }

      }

      int n1 = 0;
      for (int num : nums) {
        if (m1 == num) n1++;
      }

      int n2 = 0;
      for (int num : nums) {
        if (m2 == num) n2++;
      }
      List<Integer> result = new ArrayList<>();

      if (n1 > nums.length / 3) result.add(m1);
      if (n2 > nums.length / 3 && m2 != m1) result.add(m2);

      return result;
    }
  }

  int majorityElement2(int[] nums) {

    int count = 1;
    int majority = nums[0];
    for (int num : nums) {
      if (count == 0) {
        majority = num;
        count++;
      } else {
        if (majority == num) count++;
        else count--;
      }
    }
    if (count < 0) return -1; // this will not occur
    int c = 0;
    for (int num : nums) {
      if (num == majority) c++;
    }

    if (c > nums.length / 2) return majority;

    return -1;
  }
}

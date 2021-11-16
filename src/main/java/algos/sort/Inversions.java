package algos.sort;

import java.util.Arrays;

public class Inversions {
  private void merge(int[] nums, int[] aux, int lo, int mid, int hi, int[] inversionCount) {
    if (hi + 1 - lo >= 0) System.arraycopy(nums, lo, aux, lo, hi + 1 - lo);

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i>mid) nums[j++] = aux[k];
      else if (j > hi) nums[i++] = aux[k];
      else if (aux[i] < aux[j]) nums[i++] = aux[k];
      else {
        inversionCount[0] ++;
        nums[j++] = aux[k];
      }
    }
  }

  public void count(int[] nums, int[] aux, int lo,int hi, int[] inversionCount) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;

    count(nums, aux, lo, mid, inversionCount);
    count(nums, aux, mid+1, hi, inversionCount);
    merge(nums, aux, lo, mid, hi, inversionCount);
  }

  public int count(int[] nums) {
    int[] aux = Arrays.copyOf(nums, nums.length);
    int[] inversionConnt = new int[]{0};
    count(nums, aux, 0, nums.length - 1, inversionConnt);
    return inversionConnt[0];
  }
}

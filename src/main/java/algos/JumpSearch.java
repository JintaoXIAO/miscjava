package algos;

public class JumpSearch {
  /**
   *
   * @param k the target
   * @param sorted the array, sorted
   * @return index
   */
  public int search(int k, int[] sorted) {
    if (sorted == null || sorted.length == 0) throw new IllegalArgumentException();
    if (sorted[0] > k || sorted[sorted.length - 1] < k) return -1;

    int js = (int) Math.sqrt(sorted.length);
    return h(k, sorted, js, 0);
  }

  private int h(int k, int[] sorted, int jumpStep, int start) {
    if (start >= sorted.length) return -1;

    if (start + jumpStep >= sorted.length) {
      for (int i = start; i < sorted.length; i++) {
        if (sorted[i] == k) return i;
      }
      return -1;
    }
    if (sorted[start+jumpStep] > k) {
      for (int i = start; i < start + jumpStep; i++) {
        if (sorted[i] == k) return i;
      }
      return -1;
    }
    else if (sorted[start + jumpStep] == k) return start + jumpStep;
    else {
      return h(k, sorted, jumpStep, start + jumpStep);
    }
  }

}

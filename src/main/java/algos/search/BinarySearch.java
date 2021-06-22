package algos.search;

public class BinarySearch {
  /**
   *
   * @param k target
   * @param sorted the array on which we perform search operation, the array must be a sorted array
   * @return the index, -1 if not found
   */
  public int search(int k, int[] sorted) {
    if (sorted==null || sorted.length==0) {
      throw new IllegalArgumentException("sorted array must not be null or empty");
    }

    return h(k, sorted, 0, sorted.length);
  }

  /**
   *
   * @param k ...
   * @param sorted ...
   * @param s left index [included]
   * @param e right index [excluded]
   * @return ...
   */
  private int h(int k, int[] sorted, int s, int e) {
    if (s >= e) return -1;
    if (k < sorted[s] || k > sorted[e-1]) return -1;
    int mi = s + (e - s) / 2; // avoid integer overflow
    if (k == sorted[mi]) return mi;
    if (k < sorted[mi]) return h(k, sorted, s, mi);
    else return h(k, sorted, mi + 1, e);
  }
}

package algos.sort;

public class LinearSearch {
  /**
   *
   * @param k target
   * @param arr the array
   * @return the index of the array where array[index] == k, return -1 if not found
   */
  public int search(int k, int[] arr) {
    return h(k, arr, 0);
  }

  int h(int k, int[] arr, int i) {
    if (i >= arr.length) return -1;
    if (arr[i] == k) return i;
    return h(k, arr, i + 1);
  }
}

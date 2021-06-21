package algos;

import java.util.Arrays;

public class QuickSort {
  public void sort(int[] array) {
    if (array == null||array.length <= 1) return;
    h(array, 0, array.length - 1);
  }

  /**
   * @param array ...
   * @param s     ... first index
   * @param e     ... last index
   */
  private void h(int[] array, int s, int e) {
    if (s >= e) return;
    int pivot = array[s];
    int i = s, j = e;
    while (i <= j) {
      while (i <= j && array[i] <= pivot) i++;
      while (i <= j && array[j] > pivot) j--;
      if (i <= j) {
        swap(array, i, j);
        i++;
        j--;
      }
    }
    swap(array, s, i-1);
    h(array,s, i-2);
    h(array, i, e);
  }

  private void swap(int[] array, int i, int j) {
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
  }

  public static void main(String[] args) {
    var qs = new QuickSort();
    var arrays = new int[][]{
        {4,2,5,1,3},
        {10,7,8,9,1,5},
        {1},
        {1,0}
    };
    for (int[] arr : arrays) {
      qs.sort(arr);
      System.out.println(Arrays.toString(arr));
    }
  }
}

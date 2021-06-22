package algos.sort;

import java.util.Arrays;

public class QuickSort {
  public void sort(int[] array) {
    if (array == null||array.length <= 1) return;
    qs(array, 0, array.length - 1);
  }

  /**
   * @param array ...
   * @param s     ... first index
   * @param e     ... last index
   */
  private void qs(int[] array, int s, int e) {
    if (s >= e) return;
    int p = partition1(array, s, e);
    qs(array,s, p-1);
    qs(array, p + 1, e);
  }

  private int partition(int[] array, int s, int e) {
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
    return i - 1;
  }

  private int partition1(int[] array, int s, int e) {
    int pivot = array[e];
    int j = s - 1;
    for (int i = s; i < e; i++) {
      if (array[i] < pivot) {
        j++;
        swap(array, i, j);
      }
    }
    swap(array, j + 1, e);
    return j + 1;
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

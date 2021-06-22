package algos.sort;

import java.util.Arrays;

public class HeapSort {
  public void sort(int[] array) {
    int e = array.length - 1;
    while (e > 0) {
      heapify(array, e);
      swap(array, 0, e);
      e--;
    }
  }

  private void heapify(int[] array, int e) {
    for (int i = e; i > 0; i--) {
      int p = parent(i);
      if (array[i] > array[p]) swap(array, i, p);
      if (p == 0) return;
    }
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private void swap(int[] array, int i, int j) {
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
  }

  public static void main(String[] args) {
    var hs = new HeapSort();
    var arrays = new int[][] {
        {3,5,1,4,2},
        {0},
        {1,0}
    };
    for (int[] arr : arrays) {
      hs.sort(arr);
      System.out.println(Arrays.toString(arr));
    }
  }

}

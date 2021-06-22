package algos.sort;

import java.util.Arrays;

public class BubbleSort {
  public void sort(int[] array) {
    for (int i = array.length; i > 0; i--) {
      int j = 0;
      while (j < i - 1) {
        if (array[j] > array[j + 1]) swap(j, j + 1, array);
        j++;
      }
    }
  }

  private void swap(int i, int j, int[] arr) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  public static void main(String[] args) {
    var arrs = new int[][]{
        {1},
        {1, 0},
        {5,4,3,21}
    };
    var bs = new BubbleSort();
    for (int[] arr : arrs) {
      System.out.println("before sort: " + Arrays.toString(arr));
      bs.sort(arr);
      System.out.println("after sort: " + Arrays.toString(arr));
    }
  }
}

package algos;

import java.util.Arrays;

public class SelectionSort {
  public void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int t = array[i];
      int j = i-1;
      while (j >= 0 && t < array[j]) {
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = t;
    }
  }

  public static void main(String[] args) {
    var arrs = new int[][]{
        {3, 5, 4, 2, 1},
        {0,1},
        {1,0},
    };
    var s = new SelectionSort();
    for (int[] arr : arrs) {
      System.out.println(">> before sort: " + Arrays.toString(arr));
      s.sort(arr);
      System.out.println(">> after sort: " + Arrays.toString(arr));
    }
  }
}

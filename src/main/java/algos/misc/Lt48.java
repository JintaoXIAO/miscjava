package algos.misc;

import java.util.Arrays;

public class Lt48 {
  public static void main(String[] args) {
    int[][] arr = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    new Lt48().new Solution().rotate(arr);

    for (int r = 0; r < arr.length; r++) {
      System.out.println(Arrays.toString(arr[r]));
    }
  }


  class Solution {
    public void rotate(int[][] matrix) {
      transform1(matrix);
      transform2(matrix);
    }

    private void transform2(int[][] matrix) {
      int n = matrix.length;
      for (int r = 0; r < n; r++) {
        for (int c = r; c < n; c++) {
          int tmp = matrix[r][c];
          matrix[r][c] = matrix[c][r];
          matrix[c][r] = tmp;
        }
      }
    }

    private void transform1(int[][] matrix) {
      int n = matrix.length;
      for (int c = 0; c < n; c++) {
        int l = 0, r = n-1;
        while (l < r) {
          int tmp = matrix[l][c];
          matrix[l][c] = matrix[r][c];
          matrix[r][c] = tmp;
          l++;
          r--;
        }
      }
    }
  }
}

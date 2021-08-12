package algos.misc;

import java.util.HashSet;
import java.util.Set;

public class Lt36 {
  public static void main(String[] args) {
    var s = new Lt36().new Solution();
    var board1 = new char[][]

            {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    var board2 = new char[][]
            {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    boolean result1 = s.isValidSudoku(board1);
    System.out.println(result1);
    boolean result2 = s.isValidSudoku(board2);
    System.out.println(result2);

  }

  class Solution1 {
    public boolean isValidSudoku(char[][] board) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (board[i][j] != '.') {
            boolean checkResult = rowCheck(board, i, j)
                    && columnCheck(board, i, j)
                    && gridCheck(board, i, j);
            if (!checkResult) return false;
          }
        }
      }
      return true;
    }

    boolean rowCheck(char[][] board, int r, int c) {
      for (int i = 0; i < 9 && i != c; i++) {
        if (board[r][i] == board[r][c]) return false;
      }
      return true;
    }

    boolean columnCheck(char[][] board, int r, int c){
      for (int i = 0; i < 9 && i != r; i++) {
        if (board[i][c] == board[r][c]) return false;
      }
      return true;
    }

    boolean gridCheck(char[][] board, int r, int c) {
      int[] center = calculateGrid(r, c);
      return checkInGrid(board, center[0], center[1]);
    }


    int[][][] grids = new int[][][]{
            {{1, 1}, {1, 4}, {1, 7}},
            {{4, 1}, {4, 4}, {4, 7}},
            {{7, 1}, {7, 4}, {7, 7}}
    };
    int[] calculateGrid(int r, int c) {
      return grids[r / 3][c / 3];
    }

    boolean checkInGrid(char[][] board, int r, int c) {
      Set<Character> digits = new HashSet<>();
      for (int i = r - 1; i <= r + 1; i++) {
        for (int j = c - 1; j <= c + 1; j++) {
          if (board[i][j] != '.') {
            if (!digits.add(board[i][j])) return false;
          }
        }
      }
      return true;
    }
  }

  class Solution {
    public boolean isValidSudoku(char[][] board) {
      int[][] rows = new int[9][10];
      int[][] columns = new int[9][10];
      int[][] grids = new int[9][10];

      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          char c = board[i][j];
          if (c != '.') {
            int k = Integer.parseInt(String.valueOf(board[i][j]));
            if ((rows[i][k] != 0 ||
                    columns[j][k] != 0 ||
                    grids[(i / 3) * 3 + (j / 3)][k] != 0)) {
              return false;
            }
            rows[i][k] = k;
            columns[j][k] = k;
            grids[(i / 3) * 3 + (j / 3)][k] = k;
          }
        }
      }
      return true;
    }

  }
}

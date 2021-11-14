package algos.sort;

import java.util.Arrays;

public class Sort5 implements SwapPositionAble {
  public void sort(int[] ints5) {
    System.out.println("before: " + Arrays.toString(ints5));
    if (ints5[0] > ints5[1]) swap(ints5, 0, 1);
    if (ints5[2] > ints5[3]) swap(ints5, 2, 3);
    if (ints5[0] > ints5[2]) swap(ints5, 0, 2);
    if (ints5[1] > ints5[3]) swap(ints5, 1, 3);
    if (ints5[1] > ints5[2]) swap(ints5, 1, 2);

    if (ints5[3] > ints5[4]) swap(ints5, 3, 4);
    if (ints5[2] > ints5[3]) swap(ints5, 2, 3);
    if (ints5[1] > ints5[2]) swap(ints5, 1, 2);
    if (ints5[0] > ints5[1]) swap(ints5, 0, 1);
    System.out.println("after: " + Arrays.toString(ints5));
  }

}

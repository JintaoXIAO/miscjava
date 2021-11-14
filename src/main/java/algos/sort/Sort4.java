package algos.sort;

import java.util.Arrays;

public class Sort4 implements SwapPositionAble {
  public void sort(int[] ints4) {
    System.out.println("before: " + Arrays.toString(ints4));
    if (ints4[0] > ints4[1]) swap(ints4, 0, 1);
    if (ints4[2] > ints4[3]) swap(ints4, 2, 3);
    if (ints4[0] > ints4[2]) swap(ints4, 0, 2);
    if (ints4[1] > ints4[3]) swap(ints4, 1, 3);
    if (ints4[1] > ints4[2]) swap(ints4, 1, 2);
    System.out.println("after: " + Arrays.toString(ints4));
  }

}

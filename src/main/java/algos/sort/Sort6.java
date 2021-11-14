package algos.sort;

public class Sort6 implements SwapPositionAble {
  public void sort(int[] int6) {
    if (int6[0] > int6[1]) swap(int6, 0, 1);
    if (int6[2] > int6[3]) swap(int6, 2, 3);
    if (int6[4] > int6[5]) swap(int6, 4, 5);

    if (int6[0] > int6[2]) swap(int6, 0, 2);
    if (int6[2] > int6[4]) swap(int6, 2, 4);
    if (int6[1] > int6[3]) swap(int6, 1, 3);
    if (int6[3] > int6[5]) swap(int6, 3, 5);

    if (int6[1]>int6[2]) swap(int6,1,2);
    if (int6[3]>int6[4]) swap(int6,3,4);
    if (int6[1]>int6[3]) swap(int6, 1, 3);
    if (int6[2]>int6[4]) swap(int6, 2, 4);
    if (int6[2]>int6[3]) swap(int6, 2, 3);
  }
}

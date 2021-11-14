package algos.sort;

public interface SwapPositionAble {
  default void swap(int[] ints, int i, int j) {
    int t = ints[i];
    ints[i] = ints[j];
    ints[j] = t;
  }
}

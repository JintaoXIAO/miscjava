package algos.sort;

import java.util.Arrays;

public class Insertion1 implements CompareBasedSort {
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    for (int i = 1; i < ts.length; i++) {
      int j = i;
      T t = ts[j];
      while (j > 0 && less(t, ts[j - 1])) {
        ts[j] = ts[j - 1];
        j--;
      }
      ts[j] = t;
    }
    assert isSorted(ts);
  }

  public static void main(String[] args) {
    var is = new Insertion1();
    Character[] characters = new Character[]{'e','a','s','y','q','u','e','s','t','i','o','n'};
    is.sort(characters);
    System.out.println(Arrays.toString(characters));
  }

}

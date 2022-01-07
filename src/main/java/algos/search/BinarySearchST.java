package algos.search;

import java.lang.reflect.Array;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class BinarySearchST<Key extends Comparable<Key>, Value> {
  private static final int INIT_CAPACITY = 2;
  private Key[] keys;
  private Value[] values;
  private int n = 0;

  public BinarySearchST() {

  }

  public BinarySearchST(int capacity) {
    this.keys = (Key[]) new Comparable[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  private void resize(int capacity) {
    Key[] tmpK = (Key[]) new Comparable[capacity];
    Value[] tmpV = (Value[]) new Object[capacity];

    for (int i = 0; i <n; i++) {
      tmpK[i] = keys[i];
      tmpV[i] = values[i];
    }
    keys = tmpK;
    values = tmpV;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return 0;
  }

  public boolean contains(Key key) {
    Objects.requireNonNull(key);
    return get(key) != null;
  }

  public Value get(Key key) {
    Objects.requireNonNull(key);
    if (isEmpty()) return null;
    int i = rank(key);
    if (i<n && keys[i].compareTo(key) == 0) return values[i];
    return null;
  }

  private int rank(Key key) {
    Objects.requireNonNull(key);
    int lo = 0, hi = n - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = key.compareTo(keys[mid]);
      if (cmp < 0) hi = mid - 1;
      else if (cmp > 0) lo = mid + 1;
      else return mid;
    }
    return lo;
  }

  public void put(Key key, Value value) {
    Objects.requireNonNull(key);
    if (value == null) {
      delete(key);
      return;
    }
    int i = rank(key);
    if (i < n && keys[i].compareTo(key) == 0) {
      values[i] = value;
      return;
    }
    if (n == keys.length) resize(2 * keys.length);

    for (int j = n; j > i; j--) {
      keys[j] = keys[j-1];
      values[j] = values[j - 1];
    }

    keys[i] = key;
    values[i] = value;
    n++;
  }

  public void delete(Key key) {
    Objects.requireNonNull(key);
    if (isEmpty()) return;

    int i = rank(key);
    if (i == n || keys[i].compareTo(key) != 0) {
      return;
    }
    for (int j = i; j < n - 1; j++) {
      keys[j] = keys[j + 1];
      values[j] = values[j + 1];
    }
    n--;
    keys[n] = null;
    values[n] = null;

    if (n>0 && n == keys.length/4) resize(keys.length / 2);
  }
}

package algos.search;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SequentialSearchST <Key, Value>{
  private int n;
  private Node first;

  private class Node {
    private Key key;
    private Value value;
    private Node next;

    public Node(Key key, Value val, Node next) {
      this.key = key;
      this.value = val;
      this.next = next;
    }
  }

  public SequentialSearchST() {
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean contains(Key key) {
    Objects.requireNonNull(key);
    return get(key) != null;
  }

  public Value get(Key key) {
    Objects.requireNonNull(key);
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.value;
      }
    }
    return null;
  }

  public void put(Key key, Value value) {
    Objects.requireNonNull(key);
    if (value == null) {
      delete(key);
      return;
    }
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.value = value;
        return;
      }
    }
    first = new Node(key, value, first);
    n++;
  }

  public void delete(Key key) {
    Objects.requireNonNull(key);
    first = delete(first, key);
  }

  private Node delete(Node x, Key key) {
    if (x == null) return null;
    if (key.equals(x.key)) {
      n--;
      return x.next;
    }
    x.next = delete(x.next, key);
    return x;
  }

  public Iterable<Key> keys() {
    Queue<Key> queue = new LinkedList<>();
    for (Node x = first; x != null; x = x.next) {
      queue.offer(x.key);
    }
    return queue;
  }
}

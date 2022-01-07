package algos.search;

import java.util.NoSuchElementException;
import java.util.Objects;

public class BST<Key extends Comparable<Key>, Value> {

  private Node root;

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size(root);
  }

  private int size(Node root) {
    if (root == null) return 0;
    return root.size;
  }

  public boolean contains(Key key) {
    Objects.requireNonNull(key);
    return get(key) != null;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    Objects.requireNonNull(key);
    if (node == null) return null;
    int cmp = key.compareTo(node.key);
    if (cmp > 0) return get(node.right, key);
    else if (cmp < 0) return get(node.left, key);
    else return node.val;
  }

  public void put(Key key, Value val) {
    Objects.requireNonNull(key);
    if (val == null) {
      delete(key);
      return;
    }
    root = put(root, key, val);
  }

  private Node put(Node node, Key key, Value val) {
    if (node == null) return new Node(key, val, 1);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = put(node.left, key, val);
    else if (cmp > 0) node.right = put(node.right, key, val);
    else node.val = val;
    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }

  public void delete(Key key) {
    Objects.requireNonNull(key);
    root = delete(root, key);
  }

  private Node delete(Node node, Key key) {
    if (node == null) return null;

    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = delete(node.left, key);
    else if (cmp > 0) node.right = delete(node.right, key);
    else {
      if (node.left == null) return node.right;
      if (node.right == null) return node.left;
      Node t = node;
      node = min(t.right);
      node.right = deleteMin(t.right);
      node.left = t.left;
    }
    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }

  private Node deleteMin(Node node) {
    if (node.left == null) return node.right;
    node.left = deleteMin(node.left);
    node.size = size(node.left) + size(node.right) + 1;
    return node;
  }

  public void deleteMin() {
    if (isEmpty()) throw new NoSuchElementException();
    root = deleteMin(root);
  }

  public void deleteMax() {
    if (isEmpty()) throw new NoSuchElementException();
    root = deleteMax(root);
  }

  private Node deleteMax(Node node) {
    if (node.right == null) return node.left;
    node.right = deleteMax(node.right);
    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }

  public Key min() {
    if (isEmpty()) throw new NoSuchElementException();
    return min(root).key;
  }

  private Node min(Node node) {
    if (node.left == null) return node;
    return min(node.left);
  }

  public Key max() {
    if (isEmpty()) throw new NoSuchElementException();
    return max(root).key;
  }

  private Node max(Node node) {
    if (node.right == null) return node;
    return max(node.right);
  }

  private class Node {
    private Key key;
    private Value val;
    private Node left, right;
    private int size;

    public Node(Key key, Value val, int size) {
      this.key = key;
      this.val = val;
      this.size = size;
    }
  }
}

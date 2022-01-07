package algos.tree;

import java.util.stream.IntStream;

public class AVL {

  public static void main(String[] args) {
    var avl = new AVL();
    IntStream.of(9, 5, 10, 0, 6, 11, -1, 1, 2)
            .forEach(avl::insert);

    avl.printInPreOrder(avl.root);
    avl.delete(10);
    System.out.println("after delete 10");
    avl.printInPreOrder(avl.root);
  }

  void printInPreOrder(Node node) {
    if (node == null) return;

    System.out.print(node.key + " ");
    printInPreOrder(node.left);
    printInPreOrder(node.right);
  }

  private Node root;

  int height(Node root) {
    if (root == null) return 0;
    return root.height;
  }

  public void insert(int key) {
    this.root = insert(root, key);
  }

  private Node insert(Node root, int key) {
    if (root == null) return new Node(key);

    /* regular bst insertion */
    if (key < root.key) {
      root.left = insert(root.left, key);
    } else if (key > root.key) {
      root.right = insert(root.right, key);
    } else {
      return root;
    }

    root.height = 1 + Integer.max(height(root.left), height(root.right));

    int balance = getBalance(root);

    /* track the insertion side[left/right] of key */
    if (balance > 1 && key < root.left.key) {
      return rightRotate(root);
    }
    if (balance < -1 && key > root.right.key) {
      return leftRotate(root);
    }
    if (balance > 1 && key > root.left.key) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }
    if (balance < -1 && key < root.right.key) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }
    return root;
  }

  Node minValueNode(Node node) {
    var cur = node;
    while (cur.left != null)
      cur = cur.left;

    return cur;
  }

  public void delete(int key) {
    this.root = delete(root, key);
  }

  private Node delete(Node root, int key) {
    if (root == null)
      return null;

    if (key < root.key)
      root.left = delete(root.left, key);

    else if (key > root.key)
      root.right = delete(root.right, key);

    else {
      if (root.left != null && root.right != null) {
        /* two children case */
        Node tmp = minValueNode(root.right);
        root.key = tmp.key; // replace the root to minimum value of the right sub-tree
        root.right = delete(root.right, tmp.key);

        /* the node tobe deleted is a leaf node */
      } else if (root.left == null && root.right == null) {
        return null;

      } else {
        /* only one child or non child */
        root = (root.left != null)
                ? root.left
                : root.right;
      }
    }

    return reBalance(root);
  }

  private Node reBalance(Node root) {
    root.height = Integer.max(height(root.left), height(root.right)) + 1;

    int balance = getBalance(root);

    if (balance > 1 && getBalance(root.left) >= 0) {
      return rightRotate(root);
    }

    if (balance > 1 && getBalance(root.left) < 0) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    if (balance < -1 && getBalance(root.right) <= 0) {
      return leftRotate(root);
    }

    if (balance < -1 && getBalance(root.right) > 0) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }
    return root;
  }

  private Node rightRotate(Node y) {
    Node x = y.left;
    y.left = x.right;
    x.right = y;

    y.height = Integer.max(height(y.left), height(y.right)) + 1;
    x.height = Integer.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  private Node leftRotate(Node x) {
    Node y = x.right;
    x.right = y.left;
    y.left = x;

    x.height = Integer.max(height(x.left), height(x.right)) + 1;
    y.height = Integer.max(height(y.left), height(y.right)) + 1;

    return y;
  }

  private int getBalance(Node root) {
    if (root == null) return 0;
    return height(root.left) - height(root.right);
  }

  static class Node {
    int key, height;
    Node left, right;

    public Node(int key) {
      this.key = key;
      this.height = 1;
    }
  }
}

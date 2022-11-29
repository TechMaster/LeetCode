package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
  TreeNode root;

  BinaryTree() {
    root = null;
  }

  BinaryTree(TreeNode root) {
    this.root = root;
  }

  /*
   * BinaryTree(Integer[] arr) {
   * root = insertLevelOrder(arr, 0);
   * }
   */

  // https://stackoverflow.com/questions/37941318/how-to-build-an-incomplete-binary-tree-from-array-representation
  BinaryTree(Integer[] array) {
    if (array == null || array.length == 0) {
      return;
    }

    Queue<TreeNode> treeNodeQueue = new LinkedList<>();
    Queue<Integer> integerQueue = new LinkedList<>();
    for (int i = 1; i < array.length; i++) {
      integerQueue.offer(array[i]);
    }

    TreeNode treeNode = new TreeNode(array[0]);
    treeNodeQueue.offer(treeNode);

    while (!integerQueue.isEmpty()) {
      Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
      Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
      TreeNode current = treeNodeQueue.poll();
      if (leftVal != null) {
        TreeNode left = new TreeNode(leftVal);
        current.left = left;
        treeNodeQueue.offer(left);
      }
      if (rightVal != null) {
        TreeNode right = new TreeNode(rightVal);
        current.right = right;
        treeNodeQueue.offer(right);
      }
    }
    this.root = treeNode;
  }

  private TreeNode insertLevelOrder(Integer[] arr, int i) {
    TreeNode root = null;
    // Base case for recursion
    if (i < arr.length) {
      if (arr[i] == null) {
        return null;
      }
      root = new TreeNode(arr[i].intValue());
      // insert left child
      root.left = insertLevelOrder(arr, 2 * i + 1);
      // insert right child
      root.right = insertLevelOrder(arr, 2 * i + 2);
    }
    return root;
  }

  /* Given a binary tree, print its nodes in inorder */
  public void printInorder(TreeNode node) {
    if (node == null) {
      return;
    }
    /* first recur on left child */
    printInorder(node.left);
    /* then print the data of node */
    System.out.print(node.val + " ");
    /* now recur on right child */
    printInorder(node.right);
  }

  public void printPreorder(TreeNode node, boolean show) {
    if (node == null) {
      if (show) {
        System.out.print("null ");
      }
      return;
    }
    System.out.print(node.val + " ");
    printPreorder(node.left, node.right != null);
    printPreorder(node.right, false);
  }

  void printLevelOrder() {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      /*
       * poll() removes the present head.
       * For more information on poll() visit
       * http://www.tutorialspoint.com/java/
       * util/linkedlist_poll.htm
       */
      TreeNode tempNode = queue.poll();
      if (tempNode != null) {
        System.out.print(tempNode.val + " ");
        /* Enqueue left child */
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        } else if (tempNode.right != null) {
          queue.add(null);
        }

        /* Enqueue right child */
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
      } else {
        System.out.print("null ");
      }
    }
  }

  /*
   * Convert binary tree về dạng List
   */
  public List<Integer> convertToList() {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    ArrayList<Integer> list = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode tempNode = queue.poll();
      if (tempNode != null) {
        list.add(tempNode.val);
        /* Enqueue left child */
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        } else if (tempNode.right != null) {
          queue.add(null);
        }

        /* Enqueue right child */
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
      } else {
        list.add(null);
      }
    }
    return list;
  }

  public BinaryTree clone() {
    TreeNode cloneRootTreeNode = cloneTreeNode(this.root);
    return new BinaryTree(cloneRootTreeNode);
  }

  private TreeNode cloneTreeNode(TreeNode root) {
    // base case
    if (root == null) {
      return null;
    }
    // create a new node with the same data as the root node
    TreeNode root_copy = new TreeNode(root.val);

    // clone the left and right subtree
    root_copy.left = cloneTreeNode(root.left);
    root_copy.right = cloneTreeNode(root.right);

    // return cloned root node
    return root_copy;
  }

  public TreeNode increasingBST(TreeNode root) {
    if (root == null) {
      return null;
    }

    increasingBST(root.left);
    TreeNode root_copy = new TreeNode(root.val);
    increasingBST(root.right);
    return root_copy;
  }
}

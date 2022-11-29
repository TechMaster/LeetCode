package leetcode;

import org.junit.jupiter.api.Test;

public class Test1022 {
  void printPaths(TreeNode node) {
    int path[] = new int[10];
    printLeaf2Root(node, node, path, 0);
  }

  void printLeafToRoot(TreeNode node) {
    int path[] = new int[10];
    printLeaf2Root(node, node, path, 0);
  }

  //Print root to leaft
  void printRoot2Leaf(TreeNode node, int path[], int pathLen) {
    if (node == null)
      return;
    /* append this node to the path array */
    path[pathLen] = node.val;
    pathLen++;

    /* it's a leaf, so print the path that lead to here */
    if (node.left == null && node.right == null)
      printArray(path, pathLen);
    else {
      /* otherwise try both subtrees */
      printRoot2Leaf(node.left, path, pathLen);
      printRoot2Leaf(node.right, path, pathLen);
    }
  }

  //Print leaf to root
  void printLeaf2Root(TreeNode root, TreeNode node, int path[], int pathLen) {
    if (node == null)
      return;

    /* it's a leaf, so print the path that lead to here */
    if (node == root)
      printArray(path, pathLen);
    else {
      /* otherwise try both subtrees */
      printRoot2Leaf(node.left, path, pathLen);
      printRoot2Leaf(node.right, path, pathLen);
      path[pathLen] = node.val;
      pathLen++;
    }
    
  }

  /* Utility function that prints out an array on a line. */
  void printArray(int ints[], int len) {
    int i;
    for (i = 0; i < len; i++) {
      System.out.print(ints[i] + " ");
    }
    System.out.println("");
  }

  @Test
  void test() {
    Integer[] arr = new Integer[] { 10, 5, 15, 3, 7, 18, null };
    BinaryTree btree = new BinaryTree(arr);
    printPaths(btree.root);
  }
}

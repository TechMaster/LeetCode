package leetcode;

import org.junit.jupiter.api.Test;

public class Test938 {
  private int sum = 0;
  private void rangeBST(TreeNode node, int low, int high) {
    if (node == null)
      return;

    rangeBST(node.left, low, high);
    if (node.val >= low && node.val <= high) {
      sum += node.val;
    }
    rangeBST(node.right, low, high);
  }

  private int rangeSumBST(TreeNode root, int low, int high) {
    rangeBST(root, low, high);
    return sum;
  }

  @Test void initBinaryTree() {
    Integer[] arr = new Integer[]{10,5,15,3,7,null,18};
    BinaryTree btree = new BinaryTree(arr);
    btree.printInorder(btree.root);

    int sum = rangeSumBST(btree.root, 7, 15);
    System.out.println();
    System.out.println(sum);
  }
}

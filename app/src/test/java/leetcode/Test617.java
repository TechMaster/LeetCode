package leetcode;


import org.junit.jupiter.api.Test;

public class Test617 {
  // https://www.techiedelight.com/clone-binary-tree/
  // https://www.geeksforgeeks.org/merge-two-binary-trees-node-sum/

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null)
      return root2;
    if (root2 == null)
      return root1;
    root1.val += root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);
    return root1;
  }


  

  @Test
  void test() {
    Integer[] arr1 = new Integer[] { 1, 3, 2, 5 };
    Integer[] arr2 = new Integer[] { 2, 1, 3, null, 4, null, 7 };
    BinaryTree tree1 = new BinaryTree(arr1);
    BinaryTree tree2 = new BinaryTree(arr2);

    TreeNode mergeNode = mergeTrees(tree1.root, tree2.root);
    tree2.printPreorder(tree2.root, false);
    System.out.println();
    tree2.printLevelOrder();
    System.out.println();
    var list = tree2.convertToList();
    System.out.println(list);

    BinaryTree tree3 = tree2.clone();
    list = tree2.convertToList();
    System.out.println(list);
  }
}

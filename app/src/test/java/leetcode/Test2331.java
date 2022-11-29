package leetcode;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class Test2331 {
  Stack<Boolean> stack = new Stack<>();

  void traversePostorder(TreeNode node) {
    if (node == null)
      return;

    // first recur on left subtree
    traversePostorder(node.left);

    // then recur on right subtree
    traversePostorder(node.right);

    switch (node.val) {
      case 0:
        stack.push(false);
        break;
      case 1:
        stack.push(true);
        break;
      case 2:
        stack.push(stack.pop() || stack.pop());
        break;
      case 3:
        stack.push(stack.pop() && stack.pop());
        break;
      default:
    }
  }

  @Test
  void test() {
    Integer[] arr1 = new Integer[] {3,3,2,0,0,3,2,null,null,null,null,1,3,1,1,null,null,2,1,null,null,null,null,1,1,null,null,null,null,null,null};
    BinaryTree tree1 = new BinaryTree(arr1);
    traversePostorder(tree1.root);
    System.out.println(stack.size());
    System.out.println(stack.pop());
  }
}

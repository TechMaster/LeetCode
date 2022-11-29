package leetcode;
import org.junit.jupiter.api.Test;

public class Test897 {

  @Test void test() {
    BinaryTree tree = new BinaryTree(
      new Integer[] {5,3,6,2,4,null,8,1,null,null,null,7,9 });
    //System.out.println(tree.convertToList());
    tree.printInorder(tree.root);
  }  
}

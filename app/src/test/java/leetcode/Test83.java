package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test83 {

  public ListNode deleteDuplicates(ListNode head) {
    return null;
  }

  @Test
  void test() {
    LinkList l1 = new LinkList(new int[] { 1, 1, 2, 3, 4, 4 });
    assertThat(l1.head.toArray()).isEqualTo(new int[] { 1, 1, 2, 3, 4, 4 });
    assertThat(deleteDuplicates(l1.head).toArray()).isEqualTo(new int[] { 1, 2, 3, 4 });
  }

}

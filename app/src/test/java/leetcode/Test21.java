package leetcode;

import org.junit.jupiter.api.Test;

public class Test21 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode res = null; // con trỏ đầu của chuỗi sau khi merge
    ListNode ptr = null; // con trỏ chạy qua các phần tử của chuỗi sau khi merge
    while (true) {
      if (list1 == null) {
        if (res == null) {
          res = list2;
        } else {
          ptr.next = list2;
        }
        break;
      }
      if (list2 == null) {
        if (res == null) {
          res = list1;
        } else {
          ptr.next = list1;
        }
        break;
      }
      if (list1.val <= list2.val) {
        if (res == null) {
          res = list1;
          ptr = res;
        } else {
          ptr.next = list1;
          ptr = list1;
        }
        list1 = list1.next;
      } else if (list1.val > list2.val) {
        if (res == null) {
          res = list2;
          ptr = res;
        } else {
          ptr.next = list2;
          ptr = list2;
        }
        list2 = list2.next;
      }

    }
    return res;
  }

  @Test
  public void test() {
    LinkList l1 = new LinkList(new int[] { 1 });
    LinkList l2 = new LinkList(new int[] { 2, 2, 2, 2, 3, 4 });
    System.out.println(l1);
    System.out.println(l2);

    l1.add(0);
    l1.add(9);
    l1.add(6);
    l1.add(7);
    System.out.println(l1);
    l1.removeAtIndex(0);
    l1.removeAtIndex(3);
    l1.removeAtIndex(1);
    l1.add(10);
    l1.removeAtIndex(2);
    System.out.println(l1);

    LinkList l3 = new LinkList(new int[] { 1, 3, 3, 3, 4 });
    int count = l3.removeNodeByValue(3);
    System.out.println("count = " + count);
    System.out.println(l3);
  }

  @Test
  void testMerge() {
    LinkList list1 = new LinkList(new int[] {});
    LinkList list2 = new LinkList(new int[] { 1, 3, 4 });
    ListNode result = mergeTwoLists(list1.head, list2.head);
    LinkList l3 = new LinkList(result);
    System.out.println(l3);
  }
}

package leetcode;

public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
  public String toString() {
    ListNode ptr = this;
    StringBuilder sb = new StringBuilder();
    while (ptr != null) {
      sb.append(String.valueOf(ptr.val));
      ptr = ptr.next;
      if (ptr != null) {
        sb.append(" - ");
      }
    }
    return sb.toString();
  }
  public int length() {
    ListNode ptr = this;
    int count = 0;
    while (ptr != null) {
      count++;
      ptr = ptr.next;
    }
    return count;
  }
  public int[] toArray() {
    ListNode ptr = this;
    int[] arr = new int[this.length()];
    int i = 0;
    while (ptr != null) {
      arr[i] = ptr.val;
      ptr = ptr.next;
      i++;
    }
    return arr;
  }
}

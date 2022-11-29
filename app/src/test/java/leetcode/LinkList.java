package leetcode;

public class LinkList {
  ListNode head;
  public LinkList(ListNode head) {
    this.head = head;
  }

  //Khởi tạo LinkList từ một mảng
  public LinkList (int[] arr) {
    if (arr.length < 1) {
      this.head = null;
      return;
    };
    ListNode  ptr = null;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        ptr = new ListNode(arr[i]);
        head = ptr;
      } else {
        ptr.next = new ListNode(arr[i]);
        ptr = ptr.next;
      }
    }
    ptr.next = null;
  }

  //Thêm một phần tử
  public ListNode add(int value) {
    ListNode ptr = head;
    ListNode prev_ptr = null;
    ListNode newNode = new ListNode(value);
    while (ptr != null) {
      if (value <= ptr.val) {
        newNode.next = ptr;  //Chèn vào trước ptr
        if (head == ptr) {   //Nếu ptr là head thì đổi lại head trỏ vào newNode
          head = newNode;
        }
        if (prev_ptr != null) { //Nếu trước ptr có prev_ptr
          prev_ptr.next = newNode; //prev_ptr.next trỏ vào newNode
        }
        break;
      } else {
        prev_ptr = ptr; //prev_ptr lưu phần tử phía trước
        ptr = ptr.next;
      } 
    }

    if (ptr == null) { //Chạy đến cuối LinkList rồi, mà không có phần tử nào lớn hơn value
      prev_ptr.next = newNode; //thì chèn nó vào sau cùng
      newNode.next = null;
    }
    return newNode;
  }

  //Xoá phần tử thứ n
  public ListNode removeAtIndex(int n) {
    ListNode ptr = head;
    ListNode prev_ptr = null;
    int i = 0;
    while (i < n && ptr != null) {
      i++;
      prev_ptr = ptr;
      ptr = ptr.next;
    }
    if (i == n) {
      if (prev_ptr != null) {
        prev_ptr.next = ptr.next;
      } else {
        head = ptr.next;
      }
      return ptr;  //Trả về phần tử bị xoá
    } else {
      return null;
    }
  }
  //Xoá các phần tủ
  public int removeNodeByValue(int val) {
    ListNode ptr = head;
    ListNode prev_ptr = null;
    int count = 0;
    while (ptr != null) {
      if (ptr.val == val) {
        ptr = ptr.next; //trỏ sang phần tử tiếp theo
        if (prev_ptr != null) { // Trước đó có 1 phần tử thì
          prev_ptr.next = ptr;
        } else {
          head = ptr;
        }
        count++;
      } else if (ptr.val > val) {
        break;
      } else { //nhỏ hơn thì dịch tiếp
        prev_ptr = ptr;
        ptr = ptr.next;
      }
    }
    return count++;
  }
  public String toString() {
    ListNode ptr = head;
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
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1656 {
  public void demo() {
    OrderedStream os = new OrderedStream(6);
    os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
    os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
    os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
    os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
    os.insert(6, "fffff");
    os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"]
  }
}

class OrderedStream {
  private String[] arr;
  private int start, end;
  public OrderedStream(int n) {
    arr = new String[n];
    start = 1;
    end = 1;
  }

  public List<String> insert(int idKey, String value) {
    arr[idKey-1] = value;
    if (idKey > end) {
      end = idKey;
    }
    ArrayList<String> list = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      if (arr[i-1] == null) {
        start = i;
        break;
      } else {
        list.add(arr[i-1]);
        start = i+1;
      }
    }
    System.out.println(list);
    return list;
  }
}

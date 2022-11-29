package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2194 {
  public List<String> cellsInRange(String s) {
      char c1 = s.charAt(0);
      char c2 = s.charAt(3);
      int r1 = s.charAt(1) - 48;
      int r2 = s.charAt(4) - 48;
      ArrayList<String> arr = new ArrayList<String>();
      for (char c = c1; c <= c2; c++){
        for (int r = r1; r <= r2; r++){
          arr.add(String.format("%c%d", c, r));
        }
      }
      return arr;
  }
}

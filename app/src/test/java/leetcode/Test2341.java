package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

public class Test2341 {
  public int[] numberOfPairs(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (set.contains(num)) {
        set.remove(num);
      } else {
        set.add(num);
      }
    }
    return new int[] { (nums.length - set.size()) / 2, set.size() };
  }

  @Test
  void test() {
    int[] result = numberOfPairs(new int[] { 1, 3, 2, 1, 3, 2, 2 });
    System.out.println(result);
  }
}

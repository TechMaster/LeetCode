package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1365 {
  public int[] smallerNumbersThanCurrent1(int[] nums) {
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = 0; j < nums.length; j++) {
        if (i != j & nums[j] < nums[i]) {
          count++;
        }
      }
      ans[i] = count;
    }
    return ans;
  }

  public int[] smallerNumbersThanCurrent2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] copy = nums.clone();

    Arrays.sort(copy);

    for (int i = 0; i < nums.length; i++) {
      map.putIfAbsent(copy[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      copy[i] = map.get(nums[i]);
    }

    return copy;
  }

  public int[] smallerNumbersThanCurrent3(int[] nums) {
    int[] count = new int[101];
    int[] res = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    for (int i = 1; i <= 100; i++) {
      count[i] += count[i - 1];
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0)
        res[i] = 0;
      else
        res[i] = count[nums[i] - 1];
    }

    return res;
  }
}

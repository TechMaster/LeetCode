package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test35 {
  public int searchInsert(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (hi > lo) {
      int mid = (hi + lo) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }

    if (target > nums[hi]) {
      return hi + 1;
    } else if (nums[lo] > target) {
      return lo;
    } else { //if (nums[lo] < target && nums[hi] > target) {
      return hi;
    }
  }

  @Test void test() {
    assertThat(searchInsert(new int[]{1,3,5,6}, 5)).isEqualTo(2);
    assertThat(searchInsert(new int[]{1,3,5,6}, 3)).isEqualTo(1);
    assertThat(searchInsert(new int[]{1,3,5,6}, 4)).isEqualTo(2);
    assertThat(searchInsert(new int[]{1,3,5,6}, 3)).isEqualTo(1);
    assertThat(searchInsert(new int[]{1,3,5,6}, 2)).isEqualTo(1);
    assertThat(searchInsert(new int[]{1,3,5,6}, 7)).isEqualTo(4);
    assertThat(searchInsert(new int[]{1,3,5,6}, 0)).isEqualTo(0);
    assertThat(searchInsert(new int[]{1,3,5,6}, 6)).isEqualTo(3); 
    assertThat(searchInsert(new int[]{1,3,5,6}, 4)).isEqualTo(2);
  }
}

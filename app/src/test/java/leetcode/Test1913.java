package leetcode;
import org.junit.jupiter.api.Test;
public class Test1913 {
  public int maxProductDifference(int[] nums) {
    int max1 = 0; // max1 > max2
    int max2 = 0;
    int min1 = 10000; // min1 < min2
    int min2 = 10000;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > max1) {
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max2 = num;
      }
     

      if (num < min1) {
        min2 = min1;
        min1 = num;
      } else if (num < min2) {
        min2 = num;
      }
    }
    return max1 * max2 - min1 * min2;
  }

  @Test void test() {
    maxProductDifference(new int[]{5,6,2,7,4});
  }
}

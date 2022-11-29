package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test66 {
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    int[] temp = new int[len + 1];
    int carry = 1;
    for (int i = len - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      if (sum == 10) {
        carry = 1;
        temp[i + 1] = 0;
      } else {
        carry = 0;
        temp[i + 1] = sum;
      }
    }

    if (carry == 1) {
      temp[0] = 1;
      return temp;
    } else {
      int[] res = new int[len];
      for (int i = 0; i < len; i++) {
        res[i] = temp[i + 1];
      }
      return res;
    }
  }

  @Test void test() {
    assertThat(plusOne(new int[]{9})).isEqualTo(new int[]{1, 0});
    assertThat(plusOne(new int[]{9, 9, 9})).isEqualTo(new int[]{1, 0, 0, 0});
  }
}

package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test69 {
  public int mySqrt(int x) {
    int lo = 0, hi = x;
    while (hi > lo) {
      int mid = (hi + lo) / 2;
      long square_mid = (long) mid * mid;
      if (square_mid > x) {
        hi =  mid;
      } else if (square_mid < x) {
        lo =  mid + 1;
      } else {
        return  mid;
      }
    }

    if ((long) lo * lo > x) {
      return lo - 1;
    } else {
      return lo;
    }
  }

  @Test
  void test() {
    /*assertThat(mySqrt(4)).isEqualTo(2);
    assertThat(mySqrt(8)).isEqualTo(2);
    assertThat(mySqrt(9)).isEqualTo(3);
    assertThat(mySqrt(16)).isEqualTo(4);
    assertThat(mySqrt(80)).isEqualTo(8);
    assertThat(mySqrt(2)).isEqualTo(1);*/
    assertThat(mySqrt(2147483647)).isEqualTo(46340);
  }
}

package leetcode;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test70 {
  public int climbStairs(int n) {
    int fn_1 = 2, fn_2 = 1;
    if (n == 1) {
      return fn_2;
    }
    if (n == 2) {
      return fn_1;
    }
    int sum = 0;
    for (int i = 3; i <= n; i++) {
      sum = fn_1 + fn_2;
      fn_2 = fn_1;
      fn_1 = sum;
    }
    return sum;
  }

  @Test void test() {
    assertThat(climbStairs(2)).isEqualTo(2);
    assertThat(climbStairs(3)).isEqualTo(3);
    assertThat(climbStairs(4)).isEqualTo(5);
    assertThat(climbStairs(5)).isEqualTo(8);
  }
}

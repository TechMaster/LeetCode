package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test2315 {
  public int countAsterisks(String s) {
      int barCount = 0;
      int starCount = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '|') {
          barCount++;
        }
        if (barCount % 2 == 0 &&  c == '*') {
          starCount++;
        }
      }
      return starCount;
  }

  @Test void test() {
    assertThat(countAsterisks("l|*e*et|c**o|*de|")).isEqualTo(2);
    assertThat(countAsterisks("iamprogrammer")).isEqualTo(0);
    assertThat(countAsterisks("yo|uar|e**|b|e***au|tifu|l")).isEqualTo(5);
  }
}

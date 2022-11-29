package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test1678 {
  @Test void testIntepretString() {
    LeetCode1678 app = new LeetCode1678();
    String out = app.interpret("G()(al)");
    assertThat(out).isEqualTo("Goal");
  }
}
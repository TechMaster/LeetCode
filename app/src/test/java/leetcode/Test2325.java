package leetcode;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test2325 {
  @Test void testDecode() {
    LeetCode2325 app = new LeetCode2325();
    String result = app.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    assertThat(result).isEqualTo("this is a secret");
  }
}

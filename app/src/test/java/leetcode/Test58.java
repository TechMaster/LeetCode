package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test58 {
  public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (s.charAt(end) == ' ') {
      end--;
    }

    int begin = end;
    while (begin > 0) {
      begin--;
      if (s.charAt(begin) == ' ') {
        begin++;
        break;
      }
    }

    return s.substring(begin, end + 1).length();
  }

  @Test
  void test() {
    assertThat(lengthOfLastWord(" moon  ")).isEqualTo(4);
    assertThat(lengthOfLastWord("abc")).isEqualTo(3);
    assertThat(lengthOfLastWord(" def abc ")).isEqualTo(3);
    assertThat(lengthOfLastWord("a")).isEqualTo(1);
    assertThat(lengthOfLastWord("a  ")).isEqualTo(1);
    assertThat(lengthOfLastWord(" a")).isEqualTo(1);
  }
}

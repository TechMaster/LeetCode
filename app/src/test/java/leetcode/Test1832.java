package leetcode;

import java.util.HashSet;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test1832 {
  public boolean checkIfPangram(String sentence) {
    /*HashSet<Integer> charSet = new HashSet<>();
    char[] ch = sentence.toCharArray();
    for (char c : ch) {
      charSet.add(Integer.valueOf(c));
    }
    return charSet.size() == 26;*/
    HashSet<String> charSet = new HashSet<>();
    for (int i = 0; i < sentence.length(); i++) {
      charSet.add(sentence.substring(i, i+1));
    }
    return charSet.size() == 26;
  }

  @Test void test() {
    boolean res = checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
    assertThat(res).isTrue();

    res = checkIfPangram("leetcode");
    assertThat(res).isFalse();
  }
}

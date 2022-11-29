package leetcode;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

public class Test1859 {
  public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.charAt(s1.length()-1) - s2.charAt(s2.length()-1);
    }
  }

  public String sortSentence(String s) {
    String arr[] = s.split(" ", 0);
    Arrays.sort(arr, new StringComparator());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i].substring(0, arr[i].length()-1));
      if (i < arr.length -1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  @Test void test() {
    String result = sortSentence("is2 sentence4 This1 a3");
    assertThat(result).isEqualTo("This is a sentence");
  }
}

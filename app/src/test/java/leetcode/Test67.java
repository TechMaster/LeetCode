package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test67 {
  public String addBinary(String a, String b) {
    int lenA = a.length(), lenB = b.length();
    int len = (lenA > lenB) ? lenA : lenB;
    StringBuffer sb = new StringBuffer();
    int carry = 0;
    for (int i = 0; i < len; i++) {
      int digitA = 0, digitB = 0;
      if (i < lenA && a.charAt(lenA - 1 - i) == '1') {
        digitA = 1;
      }
      if (i < lenB && b.charAt(lenB - 1 - i) == '1') {
        digitB = 1;
      }
      int digitC = digitA ^ digitB ^ carry;
      //https://www.electronics-tutorials.ws/combination/comb_7.html
      carry = (digitA & digitB) | ((digitA ^ digitB) & carry);
      sb.insert(0, (digitC == 0) ? "0" : "1");
    }
    
    if (carry > 0) {
      sb.insert(0, "1");
    }
    return sb.toString();
  }

  @Test void test() {
    assertThat(addBinary("10", "11")).isEqualTo("101");
    assertThat(addBinary("11", "11")).isEqualTo("110");
    assertThat(addBinary("1", "1")).isEqualTo("10");
    assertThat(addBinary("111", "1")).isEqualTo("1000");
    assertThat(addBinary("111", "100")).isEqualTo("1011");
    assertThat(addBinary("111", "111")).isEqualTo("1110");
    assertThat(addBinary("1010", "1011")).isEqualTo("10101");
  }
}

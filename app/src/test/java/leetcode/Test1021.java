package leetcode;

import org.junit.jupiter.api.Test;

public class Test1021 {
  public String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    // start và stop đánh dấu bắt đầu, kết thúc của một primitive valid parentheses
    // string
    int start = 0, count = 0;
    // count là biến đếm, gặp ( thì cộng 1, gặp ) thì trừ 1, khi count về 0 thì là
    // kết thúc một chuỗi valid parentheses string
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        sb.append(s.substring(start + 1, i));
        start = i + 1;
      }
    }
    return sb.toString();
  }

  @Test void test() {
    String str = removeOuterParentheses("(()())(())");
    System.out.println(str);
  }
}

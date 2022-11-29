package leetcode;

import java.util.Stack;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Test20 {

  public boolean isValid(String s) {
    if (s.length() < 2) return false;
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(String.valueOf(c));
      } else {
        if (stack.size() == 0) {
          return false;
        }
        char prec = stack.pop().charAt(0);
        if ((c == ')' && prec != '(') ||
            (c == '}' && prec != '{') ||
            (c == ']' && prec != '[')) {
          return false;
        }
      }
    }
    return stack.size() == 0;
  }

  @Test void test() {
    assertThat(isValid("[]")).isTrue();
    assertThat(isValid("[](){}")).isTrue();
    assertThat(isValid("[({}[]())]")).isTrue();
    assertThat(isValid("[(])")).isFalse();
    assertThat(isValid("((")).isFalse();
    assertThat(isValid("){")).isFalse();
  }
}

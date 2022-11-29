package leetcode;

public class LeetCode1678 {
  public String interpret(String command) {
    int i = 0;
    StringBuffer result = new StringBuffer();
    while (i < command.length()) {
      if (command.charAt(i) == 'G') {
        result.append("G");
        i++;
        continue;
      }
      if (command.substring(i, i + 2).equals("()")) {
        result.append("o");
        i += 2;
        continue;
      }
      
      if (command.substring(i, i + 4).equals("(al)")) {
        result.append("al");
        i += 4;
        continue;
      }

    }
    return result.toString();
  }
}
